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

    // CREATE
    @Test
    public void 유저_생성_DTO(){
        UserDto userDto = UserDto.builder()
                .userNo(userService.max())
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
    public void 유저_생성_객체(){
        User user = User.builder()
                .userNo(userService.max())
                .autowire(true)
                .userName("김진성")
                .userId("Member")
                .userPw("1234")
                .division("J2KB")
                .email("kkk@naver.com")
                .build();
        userService.create(user);
    }

    @Test
    public void 유저_생성_ID(){
        userService.create(userService.max());
    }

    @Test
    public void 유저_삭제_ID(){
        userService.remove(userService.max());
    }
    // SELECT
    @Test
    public UserDto 단일_객체_조회(){
        User user = User.builder()
                .userNo(userService.max())
                .autowire(true)
                .userName("김진성")
                .userId("Member")
                .userPw("1234")
                .division("J2KB")
                .email("kkk@naver.com")
                .build();
        UserDto userDto = new UserDto();
        userDto.changeUser(userDto);
        return userDto;
    }

//    @Test
//    public UserDto 단일_DTO_조회(){
//        UserDto userDto = UserDto.builder()
//                .userNo(userService.max())
//                .autowire(true)
//                .userName("김진성")
//                .userId("Member")
//                .userPw("1234")
//                .division("J2KB")
//                .email("kkk@naver.com")
//                .build();
//        User result = userService.selectOne(userDto);
//        return result;
//    }
    // DELETE
    @Test
    public void 유저_삭제_객체(){
        User user = User.builder()
                .userNo(userService.max())
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
                .userNo(userService.max())
                .autowire(true)
                .userName("김진성")
                .userId("Member")
                .userPw("1234")
                .division("J2KB")
                .email("kkk@naver.com")
                .build();
        userService.remove(userDto);
    }

    @Test
    public void 로그인_테스트(){
        userService.login("Hello", "1234");
    }

    @Test
    public void 유저_권한부여(){
        UserDto userDto = UserDto.builder()
                .userNo(userService.max())
                .userName("진성")
                .userId("Pello")
                .division("J2KB")
                .autowire(false)
                .userPw("1234")
                .build();
        userService.autowiredUser(userDto);
    }
}