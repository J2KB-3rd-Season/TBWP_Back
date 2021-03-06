package org.j2kb.tbwp.service;

import lombok.RequiredArgsConstructor;
import org.j2kb.tbwp.domain.entity.User;
import org.j2kb.tbwp.domain.repository.UserRepository;
import org.j2kb.tbwp.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.security.auth.login.LoginException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    @Autowired
    private final UserRepository userRepository;

    LocalDateTime localDateTime = LocalDateTime.now();

    // CREATE
    public void create(User user){
        userRepository.save(user);
    }
    
    public void create(Long id){
        Optional<User> byId = userRepository.findById(id);
        if(byId.isPresent()){
            userRepository.save(byId.get());
        }else{
            throw new IllegalArgumentException();
        }
    }
    
    public void create(UserDto userDto){
        Optional<User> byId = userRepository.findById(userDto.getUserNo());
        if(byId.isPresent()){
            userRepository.save(byId.get());
        }else{
            throw new IllegalArgumentException();
        }
    }

    // Update
    public void update(User user){
        userRepository.save(user);
    }

    public void update(Long id){
        Optional<User> byId = userRepository.findById(id);
        if(byId.isPresent()){
            userRepository.save(byId.get());
        }else{
            throw new IllegalArgumentException();
        }
    }

    public void update(UserDto userDto){
        Optional<User> byId = userRepository.findById(userDto.getUserNo());
        if(byId.isPresent()){
            userRepository.save(byId.get());
        }else{
            throw new IllegalArgumentException();
        }
    }


    // SELECT
    public UserDto selectOne(User user){ // 1L -> ??????
        Optional<User> temp = userRepository.findById(user.getUserNo());
        if(temp.isPresent()){
            UserDto userDto = new UserDto();
            userDto.changeUserDto(temp.get());
            return userDto;
        }else {
            throw new IllegalArgumentException();
        }
    }

    public UserDto selectOne(Long id){
        Optional<User> temp = userRepository.findById(id);
        if(temp.isPresent()){
            UserDto userDto = new UserDto();
            userDto = userDto.changeUserDto(temp.get());
            return userDto;
        }else{
            throw new IllegalArgumentException();
        }
    }

    public UserDto selectOne(UserDto userDto){ // 1L -> ??????
        Optional<User> temp = userRepository.findById(userDto.getUserNo());
        if(temp.isPresent()){
            UserDto dto;
            dto = userDto.changeUserDto(temp.get());
            return dto;
        }else {
            throw new IllegalArgumentException();
        }
    }

    public List<User> selectAll(){
        return userRepository.findAll();
    }

    // DELETE
    public void remove(Long id){
        userRepository.deleteById(id);
    }

    public void remove(UserDto userDto){
        userRepository.deleteById(userDto.getUserNo());
    }

    public void remove(User user){
        userRepository.deleteById(user.getUserNo());
    }

    // PK ?????????
    public Long max(){
        BigDecimal max = userRepository.max();
        return Long.valueOf(String.valueOf(max));
    }

    // ????????? User Session ??????
    public HttpSession loginAutowired(HttpServletRequest request){
        HttpSession session = request.getSession();

        if(session.getAttribute("userNo")==null){
            session.setAttribute("userNo",null);
            return session;
        }else{
            Optional<User> temp = userRepository.findById(Long.valueOf(String.valueOf(session.getAttribute("userNo"))));
            temp.ifPresent(user -> session.setAttribute("userNo", user));
            return session;
        }
    }

    // User??? Login ?????? ??????
    public UserDto login(String email, String userPw, HttpServletRequest request){
        HttpSession session = request.getSession();

        UserDto dto = new UserDto();
        User user = userRepository.findByEmailAndUserPw(email, userPw);
        if (user.getUserId().equals(email) && user.getUserPw().equals(userPw)) {
            UserDto userDto = dto.changeUserDto(user);
            session.setAttribute("userNo", user.getUserId());
            return userDto;
        }else{
            throw new RuntimeException("????????? ?????????");
        }
    }

    //  ???????????? Team??? ?????? Toggle
    public void autowiredUser(UserDto userDto){
        if(userDto.getAutowire() == null || !userDto.getAutowire()){
            userDto.setAutowire(true);
            User user = userDto.changeUser(userDto);
            userRepository.save(user);
        }else{
            userDto.setAutowire(false);
            User user = userDto.changeUser(userDto);
            userRepository.save(user);
        }
    }


}
