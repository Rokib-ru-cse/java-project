package com.rokibrucse.cleanarchitecture.presentation.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.rokibrucse.cleanarchitecture.application.usecase.IUserUseCase;
import com.rokibrucse.cleanarchitecture.domain.entities.User;

import java.util.List;

public class UserController {
    @Autowired
    private IUserUseCase useCase;

    @GetMapping("/users")
    public String showUserList(Model model) {
        List<User> listUsers = useCase.listAll();
        model.addAttribute("listUsers", listUsers);
        return "user/index";
    }

    @GetMapping("/users/new")
    public String showNewUserForm(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("pageTitle", "Add New User");
        return "user/userform";
    }

    @PostMapping("/users")
    public String addusers(User user, RedirectAttributes ra) {
        useCase.saveUser(user);
        ra.addFlashAttribute("message", "user saved successfully");
        return "redirect:/users";
    }

    @GetMapping("/users/edit/{id}")
    public String showEditUserForm(@PathVariable("id") int id, Model model, RedirectAttributes ra) {
        try {
            User user = useCase.getById(id);
            model.addAttribute("user", user);
            model.addAttribute("pageTitle", "Edit user");
            return "user/userform";
        } catch (Exception e) {
            ra.addFlashAttribute("message", e.getMessage());
            return "redirect:/users";
        }
    }

    @GetMapping("/users/delete/{id}")
    public String deleteUser(@PathVariable("id") int id, RedirectAttributes ra) {
        try {
            useCase.deleteUser(id);
            ra.addFlashAttribute("message", "user has been deleted with id " + id);
        } catch (Exception e) {
            ra.addFlashAttribute("message", e.getMessage());
        }
        return "redirect:/users";
    }

}