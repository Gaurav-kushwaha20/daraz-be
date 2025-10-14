package com.gaurav.daraz.controller;

import com.gaurav.daraz.dto.ApiResponse;
import com.gaurav.daraz.dto.CategoryResponse;
import com.gaurav.daraz.entity.Category;
import com.gaurav.daraz.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


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
    public ResponseEntity<?> getAllCategory(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int pageSize
    ) {
        Pageable pageable = PageRequest.of(page, pageSize);

        List<CategoryResponse> categoriesList = categoryService.getAllCategories();
        return ResponseEntity.ok().body(new ApiResponse<List<CategoryResponse>>("Category  retrieved successfully", 200, true, categoriesList, null));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getCategoryDetails(@PathVariable("id") String id) {
        CategoryResponse category = categoryService.getCategoryDetails(id);
        return ResponseEntity.ok().body(new ApiResponse<CategoryResponse>("Category details retrieved successfully", 200, true, category, null));

    }

}
