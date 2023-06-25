package com.spring.crud.controller.user;

import com.spring.crud.model.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService service;

    @GetMapping("/users")
    public String showUserList(Model model) {
        List<User> listUsers = service.listAll();
        model.addAttribute("listUsers", listUsers);
        return "user/index";
    }

    @GetMapping("/users/new")
    public String showNewUserForm(Model model) {
        model.addAttribute("user",new User());
        model.addAttribute("pageTitle","Add New User");
        return "user/userform";
    }

    @PostMapping("/users")
    public String addusers(User user, RedirectAttributes ra) {
        service.saveUser(user);
        ra.addFlashAttribute("message","user saved successfully");
        return "redirect:/users";
    }
    @GetMapping("/users/edit/{id}")
    public String showEditUserForm(@PathVariable("id") int id,Model model,RedirectAttributes ra){
        try {
            User user = service.getById(id);
            model.addAttribute("user",user);
            model.addAttribute("pageTitle","Edit user");
            return "user/userform";
        } catch (UserNotFoundException e) {
            ra.addFlashAttribute("message",e.getMessage());
            return "redirect:/users";
        }
    }

    @GetMapping("/users/delete/{id}")
    public String deleteUser(@PathVariable("id") int id,RedirectAttributes ra) {
        try {
            service.deleteUser(id);
            ra.addFlashAttribute("message","user has been deleted with id "+id);
        } catch (UserNotFoundException e) {
            ra.addFlashAttribute("message",e.getMessage());
        }
        return "redirect:/users";
    }

}