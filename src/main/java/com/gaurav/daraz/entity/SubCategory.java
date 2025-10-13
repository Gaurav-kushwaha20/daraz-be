package com.gaurav.daraz.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "sub-category")
@Data
public class SubCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String name;
    private String description;

    // Each subcategory belongs to one category
    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;
}
