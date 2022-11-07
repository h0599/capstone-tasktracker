package com.tasktracker.springboottaskapp.services;


import com.tasktracker.springboottaskapp.dtos.TodoDto;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface TodoService {
    @Transactional
    void addTodoItem(TodoDto todoDto, Long userId);

    @Transactional
    void updateTodoItemById(TodoDto todoDto);

    List<TodoDto> getAllTodoItemByUserId(Long userId);

    Optional<TodoDto> getTodoItemById(Long todoId);

    @Transactional
    void deleteTodoItemById(Long todoId);


}
