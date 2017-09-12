package cn.veasion.bean;

import java.io.Serializable;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * 分页Model
 * 
 * @author zhuowei.luo
 */
public class PageModel<T> implements Serializable {
	
	private static final long serialVersionUID = -6283882294503153865L;
	
	@JsonIgnore
	public final static String PAGE_INDEX = "pageIndex";
	@JsonIgnore
	public final static String PAGE_COUNT = "pageCount";
	
	/**当前页数 */
	private int pageIndex = 1;
	
	/**最大页数 */
	private int maxPage;
	
	/**每页数量 */
	private int pageCount = 10;
	
	/**总结果 */
	private int count;
	
	/**查询条件对象 */
	private T obj;
	
	/**排序字段 */
	private String orderBy;
	
	/**排序 */
	private boolean isDesc = false;
	
	private List<T> result;
	
	public PageModel(){ }
	
	/**
	 * 分页Model
	 * 
	 * @param obj 查询条件对象
	 * @param pageIndex 当前页数
	 * @param pageCount 每页数量
	 */
	public PageModel(T obj, int pageIndex, int pageCount) {
		this(pageIndex, pageCount);
		this.obj = obj;
	};
	
	/**
	 * 分页Model
	 * 
	 * @param pageIndex 当前页数
	 * @param pageCount 每页数量
	 */
	public PageModel(int pageIndex, int pageCount) {
		if (pageIndex < 1)
			pageIndex = 1;
		if (pageCount < 1)
			pageCount = 1;
		this.pageIndex = pageIndex;
		this.pageCount = pageCount;
	};
	
	/** 上一页 */
	public int getTopPage() {
		return pageIndex > 1 ? pageIndex - 1 : 1;
	}
	
	/** 下一页 */
	public int getNextPage() {
		return pageIndex < maxPage ? pageIndex + 1 : maxPage;
	}
	
	/** 当前页数 */
	public int getPageIndex() {
		return pageIndex;
	}
	
	/** 当前页数 */
	public void setPageIndex(int pageIndex) {
		if (pageIndex < 1)
			pageIndex = 1;
		this.pageIndex = pageIndex;
	}
	
	/** 最大页数 */
	public int getMaxPage() {
		return (count - 1) / pageCount + 1;
	}
	
	/** 每页数量 */
	public int getPageCount() {
		return pageCount;
	}
	
	/** 每页数量 */
	public void setPageCount(int pageCount) {
		if (pageCount < 1)
			pageCount = 1;
		this.pageCount = pageCount;
	}
	
	/** 总结果 */
	public int getCount() {
		return count;
	}
	
	/** 总结果 */
	public void setCount(int count) {
		maxPage = (count - 1) / pageCount + 1;
		this.count = count;
	}
	
	/** 查询条件对象 */
	@JsonIgnore
	public Object getObj() {
		return obj;
	}
	
	/** 查询条件对象 */
	public void setObj(T obj) {
		this.obj = obj;
	}
	
	/** 排序字段 */
	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}
	
	/** 排序字段 */
	@JsonIgnore
	public String getOrderBy() {
		return orderBy;
	}
	
	/** 是否倒序 */
	public void setDesc(boolean isDesc) {
		this.isDesc = isDesc;
	}
	
	/** 是否倒序 */
	public boolean isDesc() {
		return isDesc;
	}
	
	/** MySQL Limit分页开始值 */
	@JsonIgnore
	public int getLimitStart() {
		return (pageIndex - 1) * pageCount;
	}
	
	/** MySQL Limit分页结束值 */
	@JsonIgnore
	public int getLimitEnd() {
		return pageCount;
	}
	
	/**查询结果 */
	public List<T> getResult() {
		return result;
	}

	public void setResult(List<T> result) {
		this.result = result;
	}

	@Override
	@JsonIgnore
	public String toString() {
		return "PageModel [pageIndex=" + pageIndex + ", maxPage=" + maxPage + ", pageCount=" + pageCount + ", count="
				+ count + ", obj=" + obj + ", result=" + result + "]";
	}

}
