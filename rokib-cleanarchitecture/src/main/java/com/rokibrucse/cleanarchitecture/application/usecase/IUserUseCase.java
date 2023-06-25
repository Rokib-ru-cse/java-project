package com.rokibrucse.cleanarchitecture.application.usecase;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.rokibrucse.cleanarchitecture.domain.entities.User;

import java.util.List;

@Component
public interface IUserUseCase extends UserDetailsService {

    List<User> listAll();

    void saveUser(User user);

    User getById(int id);

    void deleteUser(int id);
    UserDetails loadUserByUsername(String email) throws UsernameNotFoundException;
}
