package com.example.twitter.services;

import com.example.twitter.models.User;
import com.example.twitter.models.UserDTO;
import com.example.twitter.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<User> findAllUsers(){
        return this.userRepository.findAll();
    }

    public User AddUser(UserDTO userDTO){

        if(userRepository.findByEmail(userDTO.getEmail())!=null){
            return null;
        }
        User user = new User(userDTO.getName(),userDTO.getEmail(),userDTO.getPassword());
        return this.userRepository.save(user);
    }
}
