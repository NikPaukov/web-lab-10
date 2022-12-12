package com.example.pjwebback.repositories;

import com.example.pjwebback.entities.Department;
import com.example.pjwebback.entities.Discipline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {
    List<Department> searchAllByName (String name);
}
