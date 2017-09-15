package cn.veasion.web.home;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aliyun.oss.OSSClient;

import cn.veasion.entity.Dictionary;
import cn.veasion.face.CommonOperate;
import cn.veasion.face.FaceResponse;
import cn.veasion.face.FaceUtil;
import cn.veasion.face.ImageOperate;
import cn.veasion.face.bean.CompareBean;
import cn.veasion.face.bean.DetectBean;
import cn.veasion.face.bean.DetectBean.Faces;
import cn.veasion.face.bean.ImageTextBean;
import cn.veasion.oss.OssUploadFile;
import cn.veasion.oss.OssUtil;
import cn.veasion.service.DictionaryService;
import cn.veasion.util.ConfigUtil;
import cn.veasion.util.Constant;
import cn.veasion.util.FileUtil;
import cn.veasion.util.ImageUtil;
import cn.veasion.util.VeaUtil;

/**
 * Face Controller.
 * 
 * @author zhuowei.luo
 */
@RequestMapping("/home/face")
@Controller
public class FaceController {

	@Autowired
	private DictionaryService dictionaryService;
	
	/**
	 * 人脸识别
	 */
	@RequestMapping("/upImgFile")
	@ResponseBody
	public Map<String, Object> upImgFile(String base64Url, HttpServletRequest req){
		String []str=ImageUtil.base64Type(base64Url);
		String type=str[0];
		String base64=str[1];
		base64Url=null;str=null;
		boolean isSuccess=true;
		// 保存图像
		this.upFileToOss(base64, type);
		// 人脸识别
		CommonOperate comm=new CommonOperate(FaceUtil.getFaceKey(), FaceUtil.getFaceSecret(), false);
		Map<String, Object> respMap=new HashMap<>();
		try {
			FaceResponse resp=comm.detectBase64(base64, 0, "gender,age,smiling,glass,headpose,facequality,blur");
			DetectBean detect=new DetectBean(resp);
			if(resp.getStatus() != 200){ 
				throw new Exception("请求失败！错误码："+resp.getStatus());
			}
			StringBuilder html=new StringBuilder();
			this.fillHtml(detect, html, req);
			respMap.put("html", html.toString());
		} catch (Exception e) {
			isSuccess=false;
			e.printStackTrace();
		}
		if(!isSuccess){ 
			respMap.put("message", "检测失败！");
		}
		return respMap;
	}
	
	/**
	 * 文字识别
	 */
	@RequestMapping("/textFile")
	@ResponseBody
	public String textFile(String base64Url, HttpServletRequest req) {
		try {
			base64Url=ImageUtil.base64Type(base64Url)[1];
			if(VeaUtil.isNullEmpty(base64Url)){
				return "请选择图片！";
			}
			ImageOperate image=new ImageOperate(FaceUtil.getFaceKey(), FaceUtil.getFaceSecret());
			FaceResponse resp=image.textRecognition(null, null, base64Url);
			ImageTextBean bean=new ImageTextBean(resp);
			if (bean.getStatus() != 200)
				return bean.getMessage();
			else
				return bean.getTextHtml();
		} catch (Exception e) {
			e.printStackTrace();
			return "识别发生异常！";
		}
	}
	
	/**异步保存图片到Oss*/
	private void upFileToOss(final String base64, final String type){
		// 判断是否保存图片，不保存则return
		if(!ConfigUtil.getPropertyBoolean(Constant.SaveFaceImg, false))
			return;
		new Thread(()->{
			OSSClient client=null;
			File file=null;
			try{
				String filePath=FileUtil.HOME_PATH+"/"+UUID.randomUUID()+"."+type;
				boolean saveImg=ImageUtil.generateImage(base64, filePath);
				if(saveImg){
					file=new File(filePath);
					OssUploadFile upFile=new OssUploadFile(file, "faceImg/", null);
					client=OssUtil.getOssClient();
					OssUtil.uploadObject(client, OssUtil.bucketName, upFile, null);
				}
			}catch(Exception e){
				System.err.println("保存图片失败！");
				e.printStackTrace();
			}finally {
				if(client!=null)
					client.shutdown();
				if(file!=null && file.exists())
					file.delete();
			}
		}).start();
	}
	
	/**填充html*/
	private void fillHtml(DetectBean detect, StringBuilder html, HttpServletRequest req){
		String math[]=new String[]{"零", "一", "二", "三", "四", "五", "六", "七", "八", "九", "十"};
		List<Faces> facesList=detect.getFaces();
		boolean isMul=facesList.size()>1;
		html.append("<table>");
		for (int i = 0,len=facesList.size(); i < len; i++) {
			Faces f=facesList.get(i);
			String faceToken=f.getFaceToken();
			// 和作者人脸比较
			boolean isAuthor=this.isAutho(faceToken, req);
			if(isMul){
				// 判断是否有多个人
				html.append("<tr><td colspan='2'>").append("<br/>检测"+math[i+1]).append("</td></tr>");
			}
			if(isAuthor){
				Dictionary d=dictionaryService.randomByType(Dictionary.TYPE_PRAISE);
				String zanmei="颜值报表！";
				if (d != null) {
					zanmei = d.getValue();
				}
				// 判断是否是作者
				html.append("<tr><td colspan='2' style='color:green;font-size: 16px;'>")
				.append("&nbsp;&nbsp;&nbsp;&nbsp;")
				.append(zanmei).append("</td></tr>");
				continue;
			}
			// 性别
			html.append("<tr><td>").append("性别：").append("</td>");
			html.append("<td>").append(f.getGender()).append("</td></tr>");
			// 年龄
			html.append("<tr><td>").append("年龄：").append("</td>");
			html.append("<td>").append(f.getAge()).append("</td></tr>");
			// 相貌
			html.append("<tr><td>").append("相貌：").append("</td>");
			html.append("<td>").append(f.getFacequality()).append("</td></tr>");
			// 此时状态
			html.append("<tr><td>").append("状态：").append("</td>");
			html.append("<td>").append(f.zhuangTai()).append("</td></tr>");
			// 笑
			html.append("<tr><td>").append("is笑：").append("</td>");
			html.append("<td>").append(f.xiao()).append("</td></tr>");
			// 评估
			html.append("<tr><td>").append("评价：").append("</td>");
			html.append("<td>").append(f.veasionFace()).append("</td></tr>");
		}
		html.append("</table>");
	}
	
	/**和作者人脸比较*/
	private boolean isAutho(String faceToken, HttpServletRequest req){
		// 是否和作者进行比较
		if(!ConfigUtil.getPropertyBoolean(Constant.FaceCompareAuthor, false)){
			return false;
		}
		try {
			Object autoToken = req.getSession().getServletContext().getAttribute("faceToken");
			String authoFaceToken = autoToken != null ? autoToken.toString() : null;
			CommonOperate comm=new CommonOperate(FaceUtil.getFaceKey(), FaceUtil.getFaceSecret(), false);
			FaceResponse faceResponse=comm.compare(faceToken, null, null, null, authoFaceToken, authoFaceToken==null?FaceUtil.getMyFaceImg():null, null, null);
			if(faceResponse.getStatus()==200){
				CompareBean bean=new CompareBean(faceResponse);
				double xsl=bean.getConfidence();
				//System.out.println("相似度："+xsl);
				if(authoFaceToken==null){
					req.getSession().getServletContext().setAttribute("faceToken", bean.getFaceToken2());
				}
				if (xsl >= 85) {
					return true;
				}else{
					return false;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
}
