package com.example.pjwebback.repositories;

import com.example.pjwebback.entities.Department;
import com.example.pjwebback.entities.Discipline;
import com.example.pjwebback.entities.Faculty;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("Faculty")
public interface FacultyRepository extends JpaRepository<Faculty, Integer> {
    List<Faculty> searchAllByName (String name);

}
