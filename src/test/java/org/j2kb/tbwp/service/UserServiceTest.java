package org.j2kb.tbwp.service;

import org.j2kb.tbwp.domain.entity.User;
import org.j2kb.tbwp.dto.UserDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@SpringBootTest
class UserServiceTest {

    @Autowired
    UserServiceImpl userService;

}