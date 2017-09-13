package cn.veasion.entity;

public class VeasionMusic {
	
    private Integer id;

    private String name;

    private Integer urlId;

    private Integer imgId;

    private String singer;

    private String source;

    private Integer click;
    
    private String url;
    
    private String img;

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

    public Integer getUrlId() {
        return urlId;
    }

    public void setUrlId(Integer urlId) {
        this.urlId = urlId;
    }

    public Integer getImgId() {
        return imgId;
    }

    public void setImgId(Integer imgId) {
        this.imgId = imgId;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer == null ? null : singer.trim();
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source == null ? null : source.trim();
    }

    public Integer getClick() {
        return click;
    }

    public void setClick(Integer click) {
        this.click = click;
    }
    
    public void setImg(String img) {
		this.img = img;
	}
    
    public String getImg() {
		return img;
	}
    
    public void setUrl(String url) {
		this.url = url;
	}
    
    public String getUrl() {
		return url;
	}
}