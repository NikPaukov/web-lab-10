package com.example.pjwebback.repositories;

import com.example.pjwebback.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
List<Student> searchAllByName(String name);
List<Student> searchAllBySurname(String name);
List<Student> searchAllByNameAndSurname(String name, String surname);
}
