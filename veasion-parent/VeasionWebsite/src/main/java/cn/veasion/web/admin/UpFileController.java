package cn.veasion.web.admin;

import java.io.InputStream;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import com.aliyun.oss.OSSClient;
import cn.veasion.bean.ResponseBean;
import cn.veasion.entity.VeasionUrl;
import cn.veasion.oss.OssUploadFile;
import cn.veasion.oss.OssUtil;
import cn.veasion.service.VeasionUrlService;
import cn.veasion.util.VeaUtil;

/**
 *  Upload File Controller.
 *  
 *  @author zhuowei.luo
 */
@RequestMapping("/admin/upFile")
@Controller
public class UpFileController {

	@Autowired
	private VeasionUrlService urlService;
	
	@RequestMapping("/upImageFile")
	public String upImageFile(MultipartFile file, String name, Integer type , HttpServletRequest req){
		if(type==null || VeaUtil.isNullEmpty(name)){
			req.setAttribute("message", "上传参数错误！不能为空。");
			return ResponseBean.FAILURE;
		}
		try {
			InputStream input=file.getInputStream();
			// 上传文件到Oss
			OSSClient client=OssUtil.getOssClient();
			OssUploadFile uploadFile=new OssUploadFile(input, "images/", "image_"+type+"_"+name+".jpg");
			String ossUrl=OssUtil.uploadObject(client, OssUtil.bucketName, uploadFile, null);
			client.shutdown();
			VeasionUrl url=new VeasionUrl();
			url.setCreateDate(new Date());
			url.setName(name);
			url.setType(type);
			url.setUrl(ossUrl);
			return urlService.insertSelective(url) > 0
					? ResponseBean.SUCCESS : ResponseBean.FAILURE;
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseBean.FAILURE;
		}
	}
	
}
