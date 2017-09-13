package cn.veasion.entity;

import java.util.Date;
import java.util.List;

public class DesktopStyle {
	
	/**
	 * 正在使用
	 */
	public static final int STATUS_USE=1;
	
	/**
	 * 停用
	 */
	public static final int STATUS_STOP=0;
	
    private Integer id;

    private String name;

    private String author;

    private Integer bgimgId;

    private Integer cloumnWidth;

    private Integer cloumnHeight;

    private Date createDate;

    private Integer status;

    private String bgimg;
    
    private List<Integer> desktopCloumnIds;
    
    private List<DesktopCloumn> desktopCloumns;
    
    
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    public Integer getBgimgId() {
        return bgimgId;
    }

    public void setBgimgId(Integer bgimgId) {
        this.bgimgId = bgimgId;
    }

    public Integer getCloumnWidth() {
        return cloumnWidth;
    }

    public void setCloumnWidth(Integer cloumnWidth) {
        this.cloumnWidth = cloumnWidth;
    }

    public Integer getCloumnHeight() {
        return cloumnHeight;
    }

    public void setCloumnHeight(Integer cloumnHeight) {
        this.cloumnHeight = cloumnHeight;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
    
    public String getBgimg() {
		return bgimg;
	}
    
    public void setBgimg(String bgimg) {
		this.bgimg = bgimg;
	}
    
    public void setDesktopCloumnIds(List<Integer> desktopCloumnIds) {
		this.desktopCloumnIds = desktopCloumnIds;
	}
    
    public List<Integer> getDesktopCloumnIds() {
		return desktopCloumnIds;
	}
    
    public void setDesktopCloumns(List<DesktopCloumn> desktopCloumns) {
		this.desktopCloumns = desktopCloumns;
	}
    
    public List<DesktopCloumn> getDesktopCloumns() {
		return desktopCloumns;
	}

	@Override
	public String toString() {
		return "DesktopStyle [id=" + id + ", name=" + name + ", author=" + author + ", bgimgId=" + bgimgId
				+ ", cloumnWidth=" + cloumnWidth + ", cloumnHeight=" + cloumnHeight + ", createDate=" + createDate
				+ ", status=" + status + ", bgimg=" + bgimg + ", desktopCloumnIds=" + desktopCloumnIds
				+ ", desktopCloumns=" + desktopCloumns + "]";
	}
    
}