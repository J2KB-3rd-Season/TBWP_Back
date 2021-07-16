package org.j2kb.tbwp.service;

import org.j2kb.tbwp.domain.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class UserServiceTest {
    @Autowired
    UserService userService;

    @Test
    public void selectAll(){
        List<User> users = userService.selectAll();

        users.forEach(System.out::println);
    }
}