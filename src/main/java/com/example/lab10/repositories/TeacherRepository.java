package com.example.lab10.repositories;

import com.example.lab10.entities.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Integer> {
    List<Teacher> searchAllByNameContainingOrSurnameContainingOrderBySurname(String name, String Surname);
}
