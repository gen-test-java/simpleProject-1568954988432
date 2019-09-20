package com.test.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.test.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}