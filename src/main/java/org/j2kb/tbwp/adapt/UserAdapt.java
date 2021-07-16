package org.j2kb.tbwp.adapt;

import org.j2kb.tbwp.domain.entity.User;
import org.j2kb.tbwp.dto.UserDto;

public interface UserAdapt {
    User changeUser(UserDto userDto);
    UserDto changeUserDto(User user);
}
