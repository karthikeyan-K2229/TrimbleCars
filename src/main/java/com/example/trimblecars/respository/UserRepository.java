package com.example.trimblecars.respository;


import com.example.trimblecars.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}

