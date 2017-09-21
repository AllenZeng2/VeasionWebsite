package cn.veasion.desktop;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.OSSObjectSummary;
import com.aliyun.oss.model.ObjectListing;
import cn.veasion.oss.OssFilePage;
import cn.veasion.oss.OssUtil;

public class OssTest {

	@Test
	public void ossTest() throws Exception{
		String directory="veasion";
		OSSClient client=OssUtil.getOssClient();
		ObjectListing objectListing=OssUtil.listObjects(client, OssUtil.bucketName, directory, new OssFilePage(50));
		List<OSSObjectSummary> list=objectListing.getObjectSummaries();
		List<String> urls=new ArrayList<>();
		for (OSSObjectSummary obj : list) {
			urls.add(OssUtil.getOssFileUrl(OssUtil.bucketName, obj.getKey()));
		}
		System.out.println(urls);
	}
	
}
