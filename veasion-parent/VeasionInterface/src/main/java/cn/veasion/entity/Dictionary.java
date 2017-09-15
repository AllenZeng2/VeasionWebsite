package cn.veasion.entity;

import java.util.Date;

public class Dictionary {
	
	/**
	 * 作者名称
	 */
	public static final int TYPE_AUTHOR=1;
	
	/**
	 * Admin 暗码
	 */
	public static final int TYPE_ADMIN=2;
	
	/**
	 * 帅气赞美
	 */
	public static final int TYPE_PRAISE=3;
	
    private Integer id;

    private Integer type;

    private String value;

    private Integer status;

    private Date createDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value == null ? null : value.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

	@Override
	public String toString() {
		return "Dictionary [id=" + id + ", type=" + type + ", value=" + value + ", status=" + status + ", createDate="
				+ createDate + "]";
	}
    
}