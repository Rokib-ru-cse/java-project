package com.spring.crud;

import com.spring.crud.model.user.User;
import com.spring.crud.model.user.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class UserRepositoryTest {

    @Autowired
    private UserRepository usersRep;

    @Test
    public void testAddNew() {
        User user = new User();
        user.setEmail("rokib@gmail.com");
        user.setPassword("1111");
        user.setName("rokib");
        User savedUser = usersRep.save(user);
        Assertions.assertThat(savedUser).isNotNull();
        Assertions.assertThat(savedUser.getId()).isGreaterThan(0);
    }

    @Test
    public void testListAll() {
        Iterable<User> users = usersRep.findAll();
        Assertions.assertThat(users).hasSizeGreaterThan(0);
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void testUpdate() {
        int userId = 1;
        Optional<User> optionalUser = usersRep.findById(1);
        User user = optionalUser.get();
        user.setPassword("2222");
        usersRep.save(user);
        User updatedUser = usersRep.findById(1).get();
        Assertions.assertThat(updatedUser.getPassword()).isEqualTo("2222");
    }

    @Test
    public void testGet() {
        int userId = 1;
        Optional<User> user = usersRep.findById(userId);
        Assertions.assertThat(user).isPresent();
        System.out.println(user);
    }

    @Test
    public void testDelete(){
        int userId = 1;
        usersRep.deleteById(userId);
        Optional<User> user = usersRep.findById(userId);
        Assertions.assertThat(user).isNotPresent();
    }


}
