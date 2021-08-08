package org.j2kb.tbwp.controller;

import org.j2kb.tbwp.domain.entity.User;
import org.j2kb.tbwp.dto.UserDto;
import org.j2kb.tbwp.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class UserController {

    @Autowired
    UserServiceImpl userService;

    @GetMapping("/")
    public ResponseEntity<String> main(HttpServletRequest request) {
        userService.loginAutowired(request);
        return new ResponseEntity<>("Sucess",HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<UserDto> login(HttpServletRequest request, String email, String password){
        UserDto loginResult = userService.login(email, password);
        System.out.println(loginResult);
        if(loginResult==null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(loginResult, HttpStatus.OK);
    }

}