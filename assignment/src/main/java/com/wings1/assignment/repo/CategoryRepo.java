package com.wings1.assignment.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wings1.assignment.models.Category;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Integer>{

}
