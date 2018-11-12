package com.estate.page;

public class PageRequest implements Pageable {

	private Integer page;
	private Integer maxPageItems;
	private Integer limit;

	public PageRequest(Integer page, Integer maxPageItems) {
		this.page = page;
		this.maxPageItems = maxPageItems;
	}

	@Override
	public Integer getPageNumber() {
		return page;
	}

	@Override
	public Integer getPageSize() {
		return maxPageItems;
	}

	@Override
	public Integer getOffset() {
		return (this.page -1) * this.maxPageItems;
	}

	public Integer getLimit() {
		return limit;
	}

	public void setLimit(Integer limit) {
		this.limit = limit;
	}
}
