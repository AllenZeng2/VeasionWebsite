package cn.veasion.web.home.desktop;

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

import cn.veasion.entity.desktop.DesktopStyle;
import cn.veasion.entity.desktop.KeyValue;
import cn.veasion.entity.desktop.VeasionMusic;
import cn.veasion.oss.OssFilePage;
import cn.veasion.oss.OssUtil;
import cn.veasion.service.desktop.DesktopStyleService;
import cn.veasion.service.desktop.IpRecordService;
import cn.veasion.service.desktop.KeyValueService;
import cn.veasion.service.desktop.RedisSimpleService;
import cn.veasion.service.desktop.UserService;
import cn.veasion.service.desktop.VeasionMusicService;
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
	private KeyValueService keyValueService;
	@Autowired
	private IpRecordService ipService;
	@Autowired
	private UserService userService;
	@Autowired
	private RedisSimpleService redisSimpleService;
	
	/**
	 * 加载电脑端桌面数据 
	 */
	@RequestMapping("/loadDesktopData")
	@ResponseBody
	public DesktopStyle loadDesktopData(){
		return desktopStyleService.selectForInUse();
	}
	
	/**
	 * 加载移动端web数据
	 */
	@RequestMapping("/loadMobileData")
	public String loadMobileData(HttpServletRequest req){
		req.setAttribute("accessCount", ipService.count(null));
		req.setAttribute("desktop", loadDesktopData());
		KeyValue kv1=keyValueService.select(Constant.AUTOGRAPH);
		req.setAttribute("autograph", kv1!=null ? kv1.getValue() : "Veasion");
		KeyValue kv2=keyValueService.select(Constant.UPVOTE_COUNT);
		req.setAttribute("upvoteCount", kv2!=null ? VeaUtil.valueOfInt(kv2.getValue(), 0) : "0");
		return "home/desktop/mobile";
	}
	
	/**
	 * 点赞 
	 */
	@RequestMapping("/upvote")
	@ResponseBody
	public Boolean upvote(HttpServletRequest req){
		if(req.getSession().getAttribute(Constant.UPVOTE)==null){
			KeyValue kv=keyValueService.select(Constant.UPVOTE_COUNT);
			if(kv==null){
				keyValueService.insert(new KeyValue(Constant.UPVOTE_COUNT, "1"));
			}else{
				keyValueService.update(new KeyValue(Constant.UPVOTE_COUNT, VeaUtil.valueOfInt(kv.getValue(), 0)+1+""));
			}
			req.getSession().setAttribute(Constant.UPVOTE, Constant.UPVOTE);
			return true;
		}else{
			return false;
		}
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
		return "home/desktop/index";
	}
	
}
