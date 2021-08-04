package org.j2kb.tbwp.controller;

import org.j2kb.tbwp.domain.entity.User;
import org.j2kb.tbwp.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserServiceImpl userService;

    @GetMapping("/")
    public void test() {
        User user = User.builder()
                .email("www.naver.com")
                .division("j2kb")
                .userPw("1234")
                .userNo(1L)
                .userId("Hello")
                .userName("Hello")
                .autowire(true)
                .build();
        userService.update(user);
    }

    @GetMapping("/a")
    public void selectAll(){
        List<User> users = userService.selectAll();
        users.forEach(i->{
            System.out.println(i.getUserNo());
            System.out.println(i.getUserName());
        });
    }
}