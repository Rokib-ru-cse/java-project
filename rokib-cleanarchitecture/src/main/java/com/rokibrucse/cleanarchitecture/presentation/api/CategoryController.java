package com.rokibrucse.cleanarchitecture.presentation.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rokibrucse.cleanarchitecture.application.usecase.ICategoryUseCase;
import com.rokibrucse.cleanarchitecture.domain.entities.Category;
import com.rokibrucse.cleanarchitecture.domain.exceptionhandler.ApplicationException;
import com.rokibrucse.cleanarchitecture.domain.returnresponse.ReturnReponse;

import jakarta.validation.Valid;

@RestController
public class CategoryController {

    @Autowired
private ICategoryUseCase categoryUseCase;

    @GetMapping("/categories")
    public ReturnReponse<Category> categories() {
        return categoryUseCase.categoryList();
    }

    @PostMapping("/categories")
    public ReturnReponse<Category> saveCategory(@Valid @RequestBody Category category) throws ApplicationException {
        return null;
    }
}
