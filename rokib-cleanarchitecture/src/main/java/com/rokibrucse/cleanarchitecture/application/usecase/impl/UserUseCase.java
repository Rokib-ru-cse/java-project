package com.rokibrucse.cleanarchitecture.application.usecase.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.rokibrucse.cleanarchitecture.application.repository.IUserRepository;
import com.rokibrucse.cleanarchitecture.application.usecase.IUserUseCase;
import com.rokibrucse.cleanarchitecture.domain.entities.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserUseCase implements IUserUseCase {
    @Autowired
    private IUserRepository userRepo;

    public List<User> listAll() {
        return (List<User>) userRepo.findAll();
    }

    public void saveUser(User user) {
        userRepo.save(user);
    }

    public User getById(int id) {
        Optional<User> user = userRepo.findById(id);
        if (user.isPresent()) {
            return user.get();
        } else {
            return new User();
        }
    }

    public void deleteUser(int id) {
        Long count = userRepo.countById(id);
        if (count == null || count == 0) {
        }
        userRepo.deleteById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return new org.springframework.security.core.userdetails.User("rokib@gmail.com", "password", new ArrayList<>());
    }

}
