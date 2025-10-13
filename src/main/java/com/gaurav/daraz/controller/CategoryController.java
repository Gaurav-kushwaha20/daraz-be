package com.gaurav.daraz.controller;

import com.gaurav.daraz.dto.CategoryResponse;
import com.gaurav.daraz.entity.Category;
import com.gaurav.daraz.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/categories")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @PostMapping
    public CategoryResponse createCategory(@RequestBody Category category) {
        return categoryService.saveCategory(category);
    }

    @GetMapping
    public


}
