package cn.veasion.entity;

import java.io.Serializable;
import java.util.Date;

public class VeasionUrl implements Serializable{
	
	private static final long serialVersionUID = 4676061036203376267L;

	/**
	 * 访问链接
	 */
	public static final int TYPE_URL=1;
	
	/**
	 * 桌面背景URL
	 */
	public static final int TYPE_STYLE=2;
	
	/**
	 * ICON图标URL
	 */
	public static final int TYPE_ICON=3;
	
	/**
	 * 文件链接
	 */
	public static final int TYPE_FILE=4;
	
	
    private Integer id;

    private String name;

    private String url;

    private Integer type;

    private Date createDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}