package com.tasktracker.springboottaskapp.dtos;

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


    public TodoDto(TodoItem todoitem){
        if (todoitem.getId() != null){
            this.id = todoitem.getId();
        }
        if (todoitem.getBody() != null){
            this.body = todoitem.getBody();
    }

    }
}