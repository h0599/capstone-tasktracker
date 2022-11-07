package com.tasktracker.springboottaskapp.services;


import com.tasktracker.springboottaskapp.dtos.UserDto;
import com.tasktracker.springboottaskapp.entities.User;
import com.tasktracker.springboottaskapp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    @Transactional
    public List<String> addUser(UserDto userDto){
        List<String> response = new ArrayList<>();
        User user = new User(userDto);
        userRepository.saveAndFlush(user);
        response.add("http://http://localhost:8080/login.html");
        return response;
    }
    @Override
    public List<String> userLogin(UserDto userDto){
        List<String> response = new ArrayList<>();
       Optional<User>userOptional=userRepository.findByusername(userDto.getUsername());
        if (userOptional.isPresent()) {
            if (passwordEncoder.matches(userDto.getPassword(), userOptional.get().getPassword())) {
                response.add("http://http://localhost:8080/index.html");
                response.add(String.valueOf(userOptional.get().getId()));
            } else {
                response.add("Username or password incorrect");
            }
        }  else {
                response.add("Username or password incorrect");
            }
            return response;
        }
    }


