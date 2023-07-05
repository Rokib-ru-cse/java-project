package com.bitspondon.ecommerce.application.repository;

import com.bitspondon.ecommerce.domain.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Integer> {
}
