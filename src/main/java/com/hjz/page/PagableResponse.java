package com.hjz.page;


import java.util.List;

public class PagableResponse<T> extends ListResponse<T> {

	private static final long serialVersionUID = -481663190021787163L;
	private Data<T> data;

	public PagableResponse() {
		data = new Data();
	}

	public Data getData() {
		return data;
	}

	public void setPageNumber(Integer pageNumber) {
		this.data.setPageNumber(pageNumber);
	}

	public void setPageSize(Integer pageSize) {
		this.data.setPageSize(pageSize);
	}

	public void setCount(Long count) {
		this.data.setCount(count);
	}

	public class Data<T> {
		private Integer pageNumber;// 当前页号
		private Integer pageSize;// 每页显示数据条数
		private Long count;// 总条目数
		private Integer pageCount;//总页数
		private List<T> content;

		public Integer getPageNumber() {
			return pageNumber;
		}

		public void setPageNumber(Integer pageNumber) {
			this.pageNumber = pageNumber;
		}

		public Integer getPageSize() {
			return pageSize;
		}

		public void setPageSize(Integer pageSize) {
			this.pageSize = pageSize;
		}

		public Integer getPageCount() {
			Integer pageCount = (int) (count / pageSize);
			if (count % pageSize != 0) {
				pageCount++;
			}
			return pageCount;
		}

		public Long getCount() {
			return count;
		}

		public void setCount(Long count) {
			this.count = count;
		}

		public List<T> getContent() {
			return (List<T>) PagableResponse.this.getList();
		}

	}

}
