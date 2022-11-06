package com.tasktracker.springboottaskapp.controllers;


import com.tasktracker.springboottaskapp.dtos.TodoDto;
import com.tasktracker.springboottaskapp.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping ("http://localhost:8080/api/v1/users")
public class NoteController {
    @Autowired
    private TodoService noteService;

    @GetMapping("/user/{userId}")
    public List<TodoDto> getTodoItemsByUser(@PathVariable Long userId){
        return noteService.getTodoItemByUserId(userId);
    }
    @PostMapping("/user/{userId}")
    public void addNote (TodoDto noteDto,Long userId){
        noteService.addTodoItem(TodoDto, userId);
    }
    @DeleteMapping("/{noteId}")
    public void deleteNoteById(@PathVariable Long noteId) {
        noteService.deleteTodoItemById(noteId);
    }
    @PutMapping ("/{noteId}")
    public void updateNote(@RequestBody TodoDto noteDto) {
        noteService.updateTodoItemById(noteDto);

    }
   @GetMapping ("/{noteId}")
    public Optional<TodoDto> getNoteById (@PathVariable Long noteId){
        return noteService.getTodoItemByUserId(noteId);
}}
