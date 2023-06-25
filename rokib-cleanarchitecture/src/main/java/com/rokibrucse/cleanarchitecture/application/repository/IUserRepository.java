package com.rokibrucse.cleanarchitecture.application.repository;

import org.springframework.data.repository.CrudRepository;

import com.rokibrucse.cleanarchitecture.domain.entities.User;

public interface IUserRepository extends CrudRepository<User, Integer> {
    public Long countById(int id);
    public User findByEmail(String email);
}
