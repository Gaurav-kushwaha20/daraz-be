package com.gaurav.daraz.controller;

import com.gaurav.daraz.dto.ApiResponse;
import com.gaurav.daraz.dto.CategoryResponse;
import com.gaurav.daraz.dto.PaginationResponse;
import com.gaurav.daraz.entity.Category;
import com.gaurav.daraz.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/categories")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @PostMapping
    public ResponseEntity<?> createCategory(@RequestBody Category category) {
        CategoryResponse categoryResponse = categoryService.saveCategory(category);
        return ResponseEntity.accepted().body(new ApiResponse<CategoryResponse>("Category created successfully", 201, true, categoryResponse, null));
    }

    @GetMapping
    public ResponseEntity<?> getAllCategory(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);
        Page<CategoryResponse> categoriesList = categoryService.getAllCategories(pageable);
        PaginationResponse<CategoryResponse> paginationResponse = PaginationResponse.<CategoryResponse>builder().data(categoriesList.getContent()).totalItems(categoriesList.getTotalElements()).totalPages(categoriesList.getTotalPages()).pageSize(categoriesList.getSize()).page(categoriesList.getNumber()).counter(categoriesList.getNumberOfElements()).build();
        return ResponseEntity.ok().body(new ApiResponse<PaginationResponse<CategoryResponse>>("Category  retrieved successfully", 200, true, paginationResponse, null));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getCategoryDetails(@PathVariable("id") String id) {
        CategoryResponse category = categoryService.getCategoryDetails(id);
        return ResponseEntity.ok().body(new ApiResponse<CategoryResponse>("Category details retrieved successfully", 200, true, category, null));

    }

}
