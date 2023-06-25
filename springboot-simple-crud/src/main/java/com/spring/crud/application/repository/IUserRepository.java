package com.spring.crud.model.user;

import org.springframework.data.repository.CrudRepository;

public interface IUserRepository extends CrudRepository<User, Integer> {
    public Long countById(int id);
}
