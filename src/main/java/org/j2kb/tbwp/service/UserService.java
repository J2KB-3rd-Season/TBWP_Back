package org.j2kb.tbwp.service;

import org.j2kb.tbwp.domain.entity.User;
import org.j2kb.tbwp.dto.UserDto;

import java.util.List;


public interface UserService {
    void create(UserDto userDto);

    void create(Long id);

    void update(UserDto userDto);

    void update(Long id);

    UserDto selectOne(Long id);

    List<User> selectAll();

    void remove(Long id);

    void remove(UserDto userDto);

    Long max();

}
