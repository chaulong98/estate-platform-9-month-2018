package com.estate.page;

public interface Pageable {
	Integer getPageNumber();
	Integer getPageSize();
	Integer getOffset();
}
