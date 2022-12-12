package com.example.pjwebback.repositories;

import com.example.pjwebback.entities.Department;
import com.example.pjwebback.entities.Discipline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DisciplineRepository extends JpaRepository<Discipline, Integer> {
    List<Discipline> searchAllByName (String name);

}
