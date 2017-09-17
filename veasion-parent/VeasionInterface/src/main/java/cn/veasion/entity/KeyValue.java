package cn.veasion.entity;

import java.io.Serializable;

public class KeyValue implements Serializable{

	private static final long serialVersionUID = 2415762745935171921L;
	
	private String key;
	
	private String value;
	
	public KeyValue(){}
	
	public KeyValue(String key, String value){
		this.key=key;
		this.value=value;
	}
	
	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "KeyValue [key=" + key + ", value=" + value + "]";
	}
}