package com.rokibrucse.cleanarchitecture.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rokibrucse.cleanarchitecture.domain.entities.Category;

public interface ICategoryRepository extends JpaRepository<Category,Integer> {
}
