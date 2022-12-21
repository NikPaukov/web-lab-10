package com.example.lab10.repositories;

import com.example.lab10.entities.Discipline;
import com.example.lab10.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    List<Student> searchAllByNameContainingOrSurnameContainingOrderBySurname (String name,String Surname);
}
