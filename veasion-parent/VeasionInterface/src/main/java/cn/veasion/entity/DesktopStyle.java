package cn.veasion.entity;

import java.util.Date;

public class DesktopStyle {
    private Integer id;

    private String name;

    private String author;

    private Integer bgimg;

    private Integer cloumnWidth;

    private Integer cloumnHeight;

    private String cloumnIds;

    private Date createDate;

    private Integer status;

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

    public Integer getBgimg() {
        return bgimg;
    }

    public void setBgimg(Integer bgimg) {
        this.bgimg = bgimg;
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

    public String getCloumnIds() {
        return cloumnIds;
    }

    public void setCloumnIds(String cloumnIds) {
        this.cloumnIds = cloumnIds == null ? null : cloumnIds.trim();
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
}