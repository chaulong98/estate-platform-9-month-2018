package com.example.paging;

public interface Pageable {
    Integer getOffset();
    Integer getPageSize();
    Integer getPageNumber();
}
