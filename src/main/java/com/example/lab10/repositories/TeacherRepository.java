package com.example.lab10.repositories;

import com.example.lab10.entities.Student;
import com.example.lab10.entities.Teacher;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Integer> {
    List<Teacher> searchAllByNameContainingAndSurnameContainingOrderBySurname (String name, String Surname);
}
