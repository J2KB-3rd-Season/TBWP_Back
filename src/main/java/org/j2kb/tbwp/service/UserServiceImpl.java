package org.j2kb.tbwp.service;

import org.j2kb.tbwp.domain.entity.User;
import org.j2kb.tbwp.domain.repository.UserRepository;
import org.j2kb.tbwp.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

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
    public UserDto selectOne(User user){ // 1L -> 탈퇴
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
            userDto.changeUserDto(temp.get());
            return userDto;
        }else{
            throw new IllegalArgumentException();
        }
    }

    public UserDto selectOne(UserDto userDto){ // 1L -> 탈퇴
        Optional<User> temp = userRepository.findById(userDto.getUserNo());
        if(temp.isPresent()){
            UserDto dto = new UserDto();
            userDto.changeUserDto(temp.get());
            return userDto;
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

    // PK 최대값
    public Long max(){
        BigDecimal max = userRepository.max();
        return Long.valueOf(String.valueOf(max));
    }

}