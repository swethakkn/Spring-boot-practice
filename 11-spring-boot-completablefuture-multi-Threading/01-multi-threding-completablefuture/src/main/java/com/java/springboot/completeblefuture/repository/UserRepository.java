package com.java.springboot.completeblefuture.repository;

import com.java.springboot.completeblefuture.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
}
