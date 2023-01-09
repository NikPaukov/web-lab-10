package com.example.pjwebback.repositories;

import com.example.pjwebback.entities.Discipline;
import com.example.pjwebback.entities.Faculty;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("Faculty")
public interface FacultyRepository extends JpaRepository<Faculty, Integer> {

}
