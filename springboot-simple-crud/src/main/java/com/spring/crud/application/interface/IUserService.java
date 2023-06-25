package com.spring.crud.controller.user;

import com.spring.crud.model.user.User;
import com.spring.crud.model.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Component
public class UserService {

    List<User> listAll();
    void saveUser(User user);

    User getById(int id);

    void deleteUser(int id) ;
}
