package com.test.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.test.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}