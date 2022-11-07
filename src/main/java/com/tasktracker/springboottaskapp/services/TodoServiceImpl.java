package com.tasktracker.springboottaskapp.services;

import com.tasktracker.springboottaskapp.dtos.TodoDto;
import com.tasktracker.springboottaskapp.dtos.UserDto;
import com.tasktracker.springboottaskapp.entities.User;
import com.tasktracker.springboottaskapp.entities.TodoItem;
import com.tasktracker.springboottaskapp.repositories.TodoItemRepository;
import com.tasktracker.springboottaskapp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class TodoServiceImpl implements TodoService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TodoItemRepository todoitemRepository;

    @Override
    @Transactional
    public void addTodoItem(TodoDto todoDto, Long userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        TodoItem todoitem = new TodoItem(todoDto);
        userOptional.ifPresent(todoitem::setUser);
        todoitemRepository.saveAndFlush(todoitem);
    }

    @Override
    @Transactional
    public void updateTodoItemById(TodoDto todoDto) {
        Optional<TodoItem> todoitemOptional = todoitemRepository.findById(todoDto.getId());
        todoitemOptional.ifPresent(todo -> {
            todo.setBody(todoDto.getBody());
            todoitemRepository.saveAndFlush(todo);
        });

    }

    @Transactional
    public void deleteTodoItemById(Long todoId) {
        Optional<TodoItem> todoitemOptional = todoitemRepository.findById(todoId);
        todoitemOptional.ifPresent(todo -> todoitemRepository.delete(todo));
    }


    @Override
    public List<TodoDto> getAllTodoItemByUserId(Long userId) {
        Optional<User> userOptional =userRepository.findById(userId);
        if (userOptional.isPresent()) {
            List<TodoItem> todoList = todoitemRepository.findAllByUserEquals(userOptional.get());
            return todoList.stream().map(todo -> new TodoDto(todo)).collect(Collectors.toList());
        }
        return Collections.emptyList();
    }
    @Override
    public Optional<TodoDto> getTodoItemById(Long todoId) {
        Optional<TodoItem> todoOptional = todoitemRepository.findById(todoId);
        if (todoOptional.isPresent()) {
            return Optional.of(new TodoDto(todoOptional.get()));
        }
        return Optional.empty();
    }}

