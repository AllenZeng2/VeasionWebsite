package cn.veasion.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.veasion.service.UserService;
import cn.veasion.util.Constant;
import cn.veasion.util.VeaUtil;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService{

	@Override
	public boolean login(String value) {
		if(VeaUtil.isNullEmpty(value)){
			return false;
		}
		String code=Constant.ADMIN_CODE;
		String [] chars=value.split(",");
		if(chars.length!=code.length()){
			return false;
		}else{
			StringBuffer sb=new StringBuffer();
			try{
				for (String s : chars) {
					sb.append((char)Integer.parseInt(s));
				}
				return code.equals(sb.toString());
			}catch(Exception e){
				return false;
			}
		}
	}
	
}
