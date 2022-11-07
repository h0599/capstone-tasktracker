

package com.tasktracker.springboottaskapp.controllers;

import com.tasktracker.springboottaskapp.dtos.TodoDto;
import com.tasktracker.springboottaskapp.services.TodoService;
import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("http://localhost:8080/api/v1/users")
public class TodoItemController {
    @Autowired
    private TodoService todoService;

    @GetMapping("/user/{userId}")
    public List<TodoDto> getTodoItemByUser(@PathVariable Long userId){
        return todoService.getAllTodoItemByUserId(userId);
    }
    @PostMapping("/user/{userId}")
    public void addTodoItem (TodoDto todoDto,Long userId){
        todoService.addTodoItem(todoDto, userId);
    }
    @DeleteMapping("/{todoId}")
    public void deleteTodoItemId(@PathVariable Long todoId) {
        todoService.deleteTodoItemById(todoId);
    }
    @PutMapping ("/{todoId}")
    public void updateTodoItem(@RequestBody TodoDto TodoDto) {
        todoService.updateTodoItemById(TodoDto);

    }
    @GetMapping ("/{todoId}")
    public Optional<TodoDto> getTodoItemById (@PathVariable Long todoId){
        return todoService.getTodoItemById(todoId);
    }}


