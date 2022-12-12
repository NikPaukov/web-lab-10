package com.example.lab10.repositories;

import com.example.lab10.entities.Discipline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DisciplineRepository extends JpaRepository<Discipline, Integer> {
    List<Discipline> searchAllByName (String name);

}
