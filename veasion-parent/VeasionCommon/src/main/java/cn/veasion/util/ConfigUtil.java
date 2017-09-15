package cn.veasion.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Config配置Util类.
 * 
 * @author zhuowei.luo
 */
public class ConfigUtil {
	
	private static String CONFIG_NAME="config.properties";
	
	private static Properties p;
	
	private static Map<String, String> cache=new HashMap<>();
	
	static{
		InputStream input=ConfigUtil.class.getClassLoader().getResourceAsStream(CONFIG_NAME);
		p=new Properties();
		try {
			p.load(input);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 根据key获取值. 
	 */
	public static String getProperty(String key){
		if(!cache.isEmpty() && cache.containsKey(key)){
			return cache.get(key);
		}
		if(p!=null){
			try {
				String value=p.getProperty(key).trim();
				if (cache.size() > 200) {
					cache.clear();
				}
				cache.put(key, value);
				return value;
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}else{
			System.err.println(CONFIG_NAME+"，加载异常！");
			return null;
		}
	}
	
	/**
	 * 根据key获取值. 
	 * 
	 * @param defaultValue 如果没有或报错就返回该默认值.
	 */
	public static String getProperty(String key, String defaultValue){
		String value=getProperty(key);
		return value != null ? value : defaultValue;
	}
	
	/**
	 * 根据key获取boolean值
	 */
	public static boolean getPropertyBoolean(String key, boolean defaultVal){
		String val=getProperty(key,"none").trim();
		if("true".equalsIgnoreCase(val))
			return true;
		else if("none".equals(val))
			return defaultVal;
		else
			return false;
	}
	
}
