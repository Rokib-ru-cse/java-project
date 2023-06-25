package com.spring.crud.controller.category;

import com.spring.crud.model.category.Category;
import com.spring.crud.model.category.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
public interface ICategoryService {
    List<Category> categoryList();
    void save(Category category);
}
