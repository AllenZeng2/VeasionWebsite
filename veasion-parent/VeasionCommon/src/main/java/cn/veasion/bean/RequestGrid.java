package cn.veasion.bean;

/**
 *  Request Grid.
 *  
 *  @author zhuowei.luo
 */
public class RequestGrid {

	private Integer page;
	
	private Integer pagesize;
	
	public Integer getPage() {
		return page == null ? 1 : page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getPagesize() {
		return pagesize == null ? 10 : pagesize;
	}

	public void setPagesize(Integer pagesize) {
		this.pagesize = pagesize;
	}
	
}
