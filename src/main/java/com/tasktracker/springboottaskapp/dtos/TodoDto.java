package com.tasktracker.springboottaskapp.dtos;

import com.tasktracker.springboottaskapp.entities.TodoDto;
import com.tasktracker.springboottaskapp.entities.TodoItem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TodoDto implements Serializable {
    private Long id;
    private String body;
    private UserDto userDto;


    public TodoDto(TodoItem note){
        if (TodoItem.getId() != null){
            this.id = note.getId();
        }
        if (note.getBody() != null){
            this.body = note.getBody();
    }

    }
}