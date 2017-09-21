package cn.veasion.service.desktop.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.veasion.bean.PageModel;
import cn.veasion.entity.desktop.Dictionary;
import cn.veasion.mapper.desktop.DictionaryMapper;
import cn.veasion.service.desktop.UserService;
import cn.veasion.util.VeaUtil;

@Service("userService")
@Transactional("desktop")
public class UserServiceImpl implements UserService{

	@Autowired
	private DictionaryMapper dictionaryMapper;
	
	@Override
	public boolean login(String value) {
		if(VeaUtil.isNullEmpty(value)){
			return false;
		}
		Dictionary d=new Dictionary();
		d.setType(Dictionary.TYPE_ADMIN);
		List<Dictionary> list=dictionaryMapper.select(new PageModel<Dictionary>(d, 1, 1));
		String code="Veasion";
		if(!VeaUtil.isNullEmpty(list)){
			d=list.get(0);
			code=d.getValue();
		}
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
