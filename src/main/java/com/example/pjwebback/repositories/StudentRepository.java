package com.example.pjwebback.repositories;

import com.example.pjwebback.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
List<Student> searchAllByNameContaining(String name);
}
