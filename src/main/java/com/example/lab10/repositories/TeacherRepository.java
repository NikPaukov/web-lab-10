package com.example.lab10.repositories;

import com.example.lab10.entities.Teacher;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Integer> {

    List<Teacher> searchAllByName(String name);
    List<Teacher> searchAllBySurname(String name);
    List<Teacher> searchAllByNameAndSurname(String name, String surname);
}
