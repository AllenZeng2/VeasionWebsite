package cn.veasion.bean;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *  Response Grid.
 *  
 *  @author zhuowei.luo
 */
public class ResponseGrid<T> {

	@JsonProperty("Rows")
	private List<T> rows;
	
	@JsonProperty("Total")
	private Integer total;
	
	public ResponseGrid(List<T> rows, Integer total){
		this.rows=rows;
		this.total=total;
	}
	
	public ResponseGrid(PageModel<T> pageModel){
		this.rows=pageModel.getResult();
		this.total=pageModel.getCount();
	}
	
	public List<T> getRows() {
		return rows;
	}
	
	public Integer getTotal() {
		return total;
	}
	
}
