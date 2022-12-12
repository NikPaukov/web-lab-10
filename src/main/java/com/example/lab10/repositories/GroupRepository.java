package com.example.lab10.repositories;

import com.example.lab10.entities.Discipline;
import com.example.lab10.entities.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupRepository extends JpaRepository<Group, Integer> {
    List<Group> searchAllByNameContainingOrderByName (String name);
}
