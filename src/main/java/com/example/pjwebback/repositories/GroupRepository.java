package com.example.pjwebback.repositories;

import com.example.pjwebback.entities.Discipline;
import com.example.pjwebback.entities.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupRepository extends JpaRepository<Group, Integer> {
    List<Group> searchAllByNameContaining(String name);
}
