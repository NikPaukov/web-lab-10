package com.example.lab10.repositories;

import com.example.lab10.entities.Discipline;
import com.example.lab10.entities.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("Faculty")
public interface FacultyRepository extends JpaRepository<Faculty, Integer> {
    List<Faculty> searchAllByNameContainingOrderByName (String name);

}
