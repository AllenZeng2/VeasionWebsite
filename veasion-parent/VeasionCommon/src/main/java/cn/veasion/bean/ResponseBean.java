package cn.veasion.bean;

/**
 *  Response Bean.
 *  
 *  @author zhuowei.luo
 */
public class ResponseBean<T> {

	/**
	 * 请求成功. 
	 */
	public static final Integer STATUS_SUCCESS=0;
	
	/**
	 * 请求失败 
	 */
	public static final Integer STATUS_FAILURE=-1;
	
	/**
	 * 成功页面. 
	 */
	public static final String SUCCESS="status/success";
	
	/**
	 * 失败页面. 
	 */
	public static final String FAILURE="status/failure";
	
	private int status;
	
	private String message;
	
	private T result;
	
	public ResponseBean(T result, int status, String message){
		this(status, message);
		this.result=result;
	}
	
	public ResponseBean(int status, String message){
		this(status);
		this.message=message;
	}
	
	public ResponseBean(int status){
		this.status=status;
	}
	
	public ResponseBean(){ }
	
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getResult() {
		return result;
	}

	public void setResult(T result) {
		this.result = result;
	}
	
}
