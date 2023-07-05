package com.bitspondon.ecommerce.presentation.api;

import com.bitspondon.ecommerce.application.usecase.CategoryUseCase;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

    private CategoryUseCase useCase;

    public AdminController(CategoryUseCase useCase) {
        this.useCase = useCase;
    }

    @GetMapping("/admin")
    public String adminHome(){
        return "adminHome";
    }

}
