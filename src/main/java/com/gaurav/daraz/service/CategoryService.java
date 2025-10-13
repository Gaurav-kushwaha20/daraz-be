package com.gaurav.daraz.service;

import com.gaurav.daraz.dto.CategoryResponse;
import com.gaurav.daraz.entity.Category;
import com.gaurav.daraz.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
}
