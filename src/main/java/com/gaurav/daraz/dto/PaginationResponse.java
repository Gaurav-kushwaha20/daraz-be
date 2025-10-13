package com.gaurav.daraz.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
@Builder
public class PaginationResponse<T> {
    private List<T> data;
    private int page;
    private int pageSize;
    private long totalItems;
    private int totalPages;
    private int counter;
}
