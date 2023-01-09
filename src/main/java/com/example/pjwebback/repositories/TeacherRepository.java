package com.example.pjwebback.repositories;

import com.example.pjwebback.entities.Discipline;
import com.example.pjwebback.entities.Teacher;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Integer> {
}
