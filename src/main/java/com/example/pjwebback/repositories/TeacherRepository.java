package com.example.pjwebback.repositories;

import com.example.pjwebback.entities.Discipline;
import com.example.pjwebback.entities.Student;
import com.example.pjwebback.entities.Teacher;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Integer> {

    List<Teacher> searchAllByName(String name);
    List<Teacher> searchAllBySurname(String name);
    List<Teacher> searchAllByNameAndSurname(String name, String surname);
}
