package com.test.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.test.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}