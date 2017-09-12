package cn.veasion.entity;

import java.util.Date;

public class DesktopCloumn {
    private Integer id;

    private Integer url;

    private String title;

    private Integer icon;

    private Integer width;

    private Integer height;

    private Integer showType;

    private Integer status;

    private Date createDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUrl() {
        return url;
    }

    public void setUrl(Integer url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Integer getIcon() {
        return icon;
    }

    public void setIcon(Integer icon) {
        this.icon = icon;
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

	@Override
	public String toString() {
		return "DesktopCloumn [id=" + id + ", url=" + url + ", title=" + title + ", icon=" + icon + ", width=" + width
				+ ", height=" + height + ", showType=" + showType + ", status=" + status + ", createDate=" + createDate
				+ "]";
	}
    
}