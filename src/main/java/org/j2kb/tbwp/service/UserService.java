package org.j2kb.tbwp.service;

import org.j2kb.tbwp.domain.entity.User;
import org.j2kb.tbwp.domain.repository.UserRepository;
import org.j2kb.tbwp.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
public class UserService implements Service{

    @Autowired
    UserRepository userRepository;

    LocalDateTime localDateTime = LocalDateTime.now();
    // save : CREATE , INSERT
    // findById, findAll : SELECT
    // deleteById, deleteAll : DELETE


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
    public User selectOne(User user){ // 1L -> 탈퇴
        Optional<User> temp = userRepository.findById(user.getUserNo());
        if(temp.isPresent()){
            return temp.get();
        }else {
            throw new IllegalArgumentException();
        }
    }


    public User selectOne(Long id){ // 1L -> 탈퇴
        Optional<User> temp = userRepository.findById(id);
        if(temp.isPresent()){
            return temp.get();
        }else {
            throw new IllegalArgumentException();
        }

    }

    public User selectOne(UserDto userDto){ // 1L -> 탈퇴
        Optional<User> temp = userRepository.findById(userDto.getUserNo());
        if(temp.isPresent()){
            return temp.get();
        }else {
            throw new IllegalArgumentException();
        }
    }

    public List<User> selectAll(){
        return userRepository.findAll();
    }

    // DELETE
    @Transactional
    public void remove(Long id){
        userRepository.deleteById(id);
    }
    @Transactional
    public void remove(UserDto userDto){
        userRepository.deleteById(userDto.getUserNo());
    }
    @Transactional
    public void remove(User user){
        userRepository.deleteById(user.getUserNo());
    }

}
