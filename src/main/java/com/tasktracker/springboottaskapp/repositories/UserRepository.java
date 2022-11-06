package com.tasktracker.springboottaskapp.repositories;


import com.tasktracker.springboottaskapp.entities.User;
import com.tasktracker.springboottaskapp.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByusername (String username);
}
