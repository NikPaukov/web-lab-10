package com.example.pjwebback.repositories;

import com.example.pjwebback.entities.Department;
import com.example.pjwebback.entities.Discipline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {
}
