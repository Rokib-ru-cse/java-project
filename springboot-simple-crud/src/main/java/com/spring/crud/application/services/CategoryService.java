package com.spring.crud.controller.category;

import com.spring.crud.model.category.Category;
import com.spring.crud.model.category.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {

    @Autowired
    private ICategoryRepository categoryRepo;

    public List<Category> categoryList() {
        return (List<Category>) categoryRepo.findAll();
    }

    public void save(Category category) {
        categoryRepo.save(category);
    }
}
