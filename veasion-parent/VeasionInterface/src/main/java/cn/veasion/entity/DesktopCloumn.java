package cn.veasion.entity;

import java.util.Date;

public class DesktopCloumn {
	
	/**
	 * 常规
	 */
	public static final Integer SHOW_TYPE_ROUTINE=0;
	
	/**
	 * 最大化 
	 */
	public static final Integer SHOW_TYPE_MAX=1;
	
	/**
	 * 最小化 
	 */
	public static final Integer SHOW_TYPE_MIN=2;
	
	/**
	 * 打开新窗体 
	 */
	public static final Integer SHOW_TYPE_NEW=3;
	
	/**
	 * 不准最大化 
	 */
	public static final Integer SHOW_TYPE_NOMAX=4;
	
	public static final String [] SHOW_TYPES={"常规", "最大化", "最小化", "打开新窗体", "不准最大化"};
	
	/**
	 * 可用
	 */
	public static final Integer STATUS_USE=1;
	
	/**
	 * 停用
	 */
	public static final int STATUS_STOP=0;
	
    private Integer id;

    private Integer urlId;

    private String title;

    private Integer iconId;

    private Integer width;

    private Integer height;

    private Integer showType;

    private Integer status;

    private Date createDate;

    private String url;
    
    private String icon;
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUrlId() {
        return urlId;
    }

    public void setUrlId(Integer urlId) {
        this.urlId = urlId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Integer getIconId() {
        return iconId;
    }

    public void setIconId(Integer iconId) {
        this.iconId = iconId;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getShowType() {
        return showType;
    }

    public void setShowType(Integer showType) {
        this.showType = showType;
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

    public String getIcon() {
		return icon;
	}
    
    public void setIcon(String icon) {
		this.icon = icon;
	}
    
    public String getUrl() {
		return url;
	}
    
    public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "DesktopCloumn [id=" + id + ", urlId=" + urlId + ", title=" + title + ", iconId=" + iconId + ", width="
				+ width + ", height=" + height + ", showType=" + showType + ", status=" + status + ", createDate="
				+ createDate + ", url=" + url + ", icon=" + icon + "]";
	}
    
}