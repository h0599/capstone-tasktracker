package com.tasktracker.springboottaskapp.repositories;

import com.tasktracker.springboottaskapp.entities.TodoItem;
import com.tasktracker.springboottaskapp.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TodoItemRepository extends JpaRepository<TodoItem, Long> {
    List<TodoItem> findAllByUserEquals(User user);
}