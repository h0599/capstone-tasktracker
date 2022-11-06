package com.tasktracker.springboottaskapp.services;

import com.tasktracker.springboottaskapp.dtos.TodoDto;
import com.tasktracker.springboottaskapp.dtos.UserDto;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserService {
    @Transactional
    List<String> addUser(UserDto userDto);

    List<String> userLogin(UserDto userDto);
}
