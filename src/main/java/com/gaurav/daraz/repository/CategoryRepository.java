package com.gaurav.daraz.repository;

import com.gaurav.daraz.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, String> {
}
