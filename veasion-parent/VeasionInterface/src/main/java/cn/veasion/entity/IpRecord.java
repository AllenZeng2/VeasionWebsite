package cn.veasion.entity;

import java.io.Serializable;
import java.util.Date;

public class IpRecord implements Serializable{
	
	private static final long serialVersionUID = 7775438981940662041L;

	/**
	 * 时间排序字段 
	 */
	public static final String ORDER_BY_DATE="date";
	
    private Integer id;

    private String ip;

    private Date date;

    private Integer line;

    private String area;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getLine() {
        return line;
    }

    public void setLine(Integer line) {
        this.line = line;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area == null ? null : area.trim();
    }
}