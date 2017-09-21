package cn.veasion.web.home.website;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.veasion.service.website.TestService;
import cn.veasion.util.VeaUtil;


@RequestMapping("/home/website")
@Controller
public class TestControll {

	@Autowired
	private TestService testService;
	
	@RequestMapping("/test")
	@ResponseBody
	public cn.veasion.entity.website.Test test(){
		List<cn.veasion.entity.website.Test> list=testService.select();
		return VeaUtil.isNullEmpty(list) ? null : list.get(0);
	}
	
}
