package com.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.main.model.RatingCategory;

public interface RatingCategoryRepository extends JpaRepository<RatingCategory, String> {

}
