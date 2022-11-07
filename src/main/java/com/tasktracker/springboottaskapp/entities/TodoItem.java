package com.tasktracker.springboottaskapp.entities;

import com.tasktracker.springboottaskapp.dtos.TodoDto;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "todo")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TodoItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String body;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name="user_id")
    private User user;

    public TodoItem (TodoDto todoDto) {
        if (todoDto.getBody() != null) {
            this.body = todoDto.getBody();
        }
    }
}

