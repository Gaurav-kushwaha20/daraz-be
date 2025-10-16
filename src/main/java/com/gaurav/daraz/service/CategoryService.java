package com.gaurav.daraz.service;

import com.gaurav.daraz.dto.CategoryResponse;
import com.gaurav.daraz.entity.Category;
import com.gaurav.daraz.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryResponse saveCategory(Category category) {
        Category saved = categoryRepository.save(category);
        return this.categoryToCategoryResponse(saved);
    }

    public CategoryResponse categoryToCategoryResponse(Category category) {
        return CategoryResponse.builder().id(category.getId()).name(category.getName()).description(category.getDescription()).build();
    }


    public CategoryResponse getCategoryDetails(String id) {
        Category category = categoryRepository.findById(id).orElseThrow( ()-> new RuntimeException("category not found"));
        return this.categoryToCategoryResponse(category);
    }

    public Page<CategoryResponse> getAllCategories(Pageable pageable) {
        Page<Category> categoryPage = categoryRepository.findAll(pageable);
        return categoryPage.map(this::categoryToCategoryResponse);
    }
}
