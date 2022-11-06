package com.tasktracker.springboottaskapp.repositories;

import com.tasktracker.springboottaskapp.entities.TodoItem;
import org.springframework.data.repository.CrudRepository;

public interface TodoItemRepository extends CrudRepository<TodoItem, Long> {
}
