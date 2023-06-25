package com.rokibrucse.cleanarchitecture.application.usecase;

import org.springframework.stereotype.Component;

import com.rokibrucse.cleanarchitecture.domain.entities.Category;
import com.rokibrucse.cleanarchitecture.domain.returnresponse.ReturnReponse;

import java.util.List;

@Component
public interface ICategoryUseCase {
    ReturnReponse<Category> categoryList();
    Category save(Category category);
}
