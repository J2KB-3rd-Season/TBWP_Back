package org.j2kb.tbwp.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import org.j2kb.tbwp.domain.entity.User;
import org.j2kb.tbwp.dto.UserDto;
import org.j2kb.tbwp.service.UserServiceImpl;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class UserController {

    @Autowired
    UserServiceImpl userService;

    @GetMapping("/")
    public ResponseEntity<String> main(HttpServletRequest request) {
        JSONObject jsonObj = new JSONObject();

        jsonObj.put("res", "Hello Tbwp");

        userService.loginAutowired(request);
        return new ResponseEntity<>(jsonObj.toJSONString(),HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(HttpServletRequest request, String email, String password){
        JSONObject jsonObject = new JSONObject();

        UserDto result = userService.login(email, password, request);

        if(result == null){
            jsonObject.put("res", "Login Fail");
            return new ResponseEntity<>(jsonObject.toJSONString(), HttpStatus.BAD_REQUEST);
        }
        jsonObject.put("res", "Login Success");
        jsonObject.put("data", result.toString());
        return new ResponseEntity<>(jsonObject.toJSONString(), HttpStatus.OK);
    }



}