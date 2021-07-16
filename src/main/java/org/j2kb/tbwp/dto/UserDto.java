package org.j2kb.tbwp.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.j2kb.tbwp.adapt.UserAdapt;
import org.j2kb.tbwp.domain.entity.User;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto implements UserAdapt {
    Long userNo; // 고유번호

    String userName; // 이름

    String userId; // 아이디

    String userPw; // 비밀번호

    String email; // 이메일

    String division; // 부서

    Boolean autowire; // 권한

    @Override
    public User changeUser(UserDto userDto) {
        User user = User.builder()
                .userNo(userDto.getUserNo())
                .userId(userDto.getUserId())
                .userPw(userDto.getUserPw())
                .userName(userDto.getUserName())
                .division(userDto.getDivision())
                .email(userDto.getEmail())
                .autowire(userDto.getAutowire())
                .build();
        return user;
    }

    @Override
    public UserDto changeUserDto(User user) {
        UserDto userDto = UserDto.builder()
                .userNo(user.getUserNo())
                .userId(user.getUserId())
                .userPw(user.getUserPw())
                .userName(user.getUserName())
                .division(user.getDivision())
                .email(user.getEmail())
                .autowire(user.getAutowire())
                .build();
        return userDto;
    }
}
