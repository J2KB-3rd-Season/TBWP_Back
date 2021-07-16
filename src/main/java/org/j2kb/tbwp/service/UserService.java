package org.j2kb.tbwp.service;

import org.j2kb.tbwp.domain.entity.User;
import org.j2kb.tbwp.domain.repository.UserRepository;
import org.j2kb.tbwp.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
public class UserService implements Service{

    @Autowired
    UserRepository userRepository;

    // save : CREATE , INSERT
    // findById, findAll : SELECT
    // deleteById, deleteAll : DELETE


    // CREATE
    public void create(User user){
        userRepository.save(user);
    }
    
    public void create(Long id){
        Optional<User> byId = userRepository.findById(id);
        userRepository.save(byId.get());
    }
    
    public void create(UserDto userDto){
        Optional<User> byId = userRepository.findById(userDto.getUserNo());
        userRepository.save(byId.get());
    }

    // Update
    public void update(User user){
        userRepository.save(user);
    }

    public void update(Long id){
        Optional<User> byId = userRepository.findById(id);
        userRepository.save(byId.get());
    }

    public void update(UserDto userDto){
        Optional<User> byId = userRepository.findById(userDto.getUserNo());
        userRepository.save(byId.get());
    }


    // SELECT
    public User selectOne(User user){ // 1L -> 탈퇴
        Optional<User> temp = userRepository.findById(user.getUserNo());
        if(temp.isPresent()){
            return temp.get();
        }else {
            User entity = User.builder()
                    .userNo(1L)
                    .email("탈퇴한 회원")
                    .division("탈퇴한 회원")
                    .userPw("탈퇴한 회원")
                    .userId("탈퇴한 회원")
                    .userName("탈퇴한 회원")
                    .autowire(false)
                    .build();
            return entity;
        }
    }


    public User selectOne(Long id){ // 1L -> 탈퇴
        Optional<User> temp = userRepository.findById(id);
        if(temp.isPresent()){
            return temp.get();
        }else {
            User entity = User.builder()
                    .userNo(1L)
                    .email("탈퇴한 회원")
                    .division("탈퇴한 회원")
                    .userPw("탈퇴한 회원")
                    .userId("탈퇴한 회원")
                    .userName("탈퇴한 회원")
                    .autowire(false)
                    .build();
            return entity;
        }

    }

    public User selectOne(UserDto userDto){ // 1L -> 탈퇴
        Optional<User> temp = userRepository.findById(userDto.getUserNo());
        if(temp.isPresent()){
            return temp.get();
        }else {
            User entity = User.builder()
                    .userNo(1L)
                    .email("탈퇴한 회원")
                    .division("탈퇴한 회원")
                    .userPw("탈퇴한 회원")
                    .userId("탈퇴한 회원")
                    .userName("탈퇴한 회원")
                    .autowire(false)
                    .build();
            return entity;
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

}
