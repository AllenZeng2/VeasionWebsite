package cn.veasion.web.home;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.OSSObjectSummary;
import com.aliyun.oss.model.ObjectListing;

import cn.veasion.entity.DesktopStyle;
import cn.veasion.entity.VeasionMusic;
import cn.veasion.oss.OssFilePage;
import cn.veasion.oss.OssUtil;
import cn.veasion.service.DesktopStyleService;
import cn.veasion.service.RedisSimpleService;
import cn.veasion.service.UserService;
import cn.veasion.service.VeasionMusicService;
import cn.veasion.util.Constant;
import cn.veasion.util.VeaUtil;
import net.sf.json.JSONArray;

/**
 * Desktop Controller.
 * 
 * @author zhuowei.luo
 */
@RequestMapping("/home/desktop")
@Controller
public class DesktopController {

	@Autowired
	private DesktopStyleService desktopStyleService;
	@Autowired
	private VeasionMusicService musicService;
	@Autowired
	private UserService userService;
	@Autowired
	private RedisSimpleService redisSimpleService;
	
	/**
	 * 加载正在使用的桌面数据 
	 */
	@RequestMapping("/loadDesktopData")
	@ResponseBody
	public DesktopStyle loadDesktopData(){
		return desktopStyleService.selectForInUse();
	}
	
	/**
	 * 管理员暗码验证. 
	 */
	@RequestMapping("/adminValidation")
	@ResponseBody
	public Boolean adminValidation(String value, HttpServletRequest request){
		if(userService.login(value)){
			request.getSession().setAttribute(Constant.ADMIN_SESSION, Constant.ADMIN_SESSION);
			return true;
		}else{
			return false;
		}
	}
	
	@RequestMapping("/exitLogin")
	@ResponseBody
	public Boolean exitLogin(HttpServletRequest request){
		request.removeAttribute(Constant.ADMIN_SESSION);
		return true;
	}
	
	@RequestMapping("/index")
	public String index(HttpServletRequest request){
		try {
			List<VeasionMusic> music=musicService.random(5);
			if(!VeaUtil.isNullEmpty(music)){
				// index背景音乐
				request.setAttribute("bgsounds", music);
			}
			// index图片
			Serializable ossUrlSet=redisSimpleService.get("OssUrlSet");
			if(ossUrlSet!=null && ossUrlSet instanceof HashSet){
				String veasionUrls=JSONArray.fromObject(new ArrayList<>((HashSet<?>)ossUrlSet)).toString();
				request.setAttribute("veasionUrls", veasionUrls);
			}else{
				OSSClient client=OssUtil.getOssClient();
				ObjectListing objectListing=OssUtil.listObjects(client, OssUtil.bucketName, "veasion/", new OssFilePage(50));
				List<OSSObjectSummary> list=objectListing.getObjectSummaries();
				Set<String> urlSet=new HashSet<>();
				for (OSSObjectSummary obj : list) {
					if(obj.getKey().endsWith("/")){
						continue;
					}
					urlSet.add(OssUtil.getOssFileUrl(OssUtil.bucketName, obj.getKey()));
				}
				redisSimpleService.add("OssUrlSet", new HashSet<>(urlSet), 12, TimeUnit.HOURS);
				String veasionUrls=JSONArray.fromObject(new ArrayList<>(urlSet)).toString();
				request.setAttribute("veasionUrls", veasionUrls);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "index";
	}
	
}
