package org.j2kb.tbwp.service;

import org.j2kb.tbwp.domain.entity.User;
import org.j2kb.tbwp.dto.UserDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
class UserServiceTest {
    @Autowired
    UserService userService;

    @Test
    public void 유저_생성_DTO(){
        UserDto userDto = UserDto.builder()
                .userNo(1L)
                .autowire(true)
                .userName("김진성")
                .userId("Member")
                .userPw("1234")
                .division("J2KB")
                .email("kkk@naver.com")
                .build();
        userService.create(userDto);
    }

    @Test
    @Transactional
    public void 유저_삭제_ID(){
        userService.remove(1L);
    }

    @Test
    public void 유저_삭제_객체(){
        User user = User.builder()
                .userNo(2L)
                .autowire(true)
                .userName("김진성")
                .userId("Member")
                .userPw("1234")
                .division("J2KB")
                .email("kkk@naver.com")
                .build();
        userService.remove(user);
    }

    @Test
    public void 유저_삭제_DTO(){
        UserDto userDto = UserDto.builder()
                .userNo(1L)
                .autowire(true)
                .userName("김진성")
                .userId("Member")
                .userPw("1234")
                .division("J2KB")
                .email("kkk@naver.com")
                .build();
        userService.remove(userDto);
    }
}