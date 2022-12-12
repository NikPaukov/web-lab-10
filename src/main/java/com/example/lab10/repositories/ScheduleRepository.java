package com.example.lab10.repositories;

import com.example.lab10.entities.*;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Integer> {
 Page<Schedule> findAllByGroup(@NotNull Group group, Pageable pageable);
 Page<Schedule> findAllByTeacher(@NotNull Teacher teacher, Pageable pageable);
 Page<Schedule> findAllByDiscipline(@NotNull Discipline discipline, Pageable pageable);
 List<Schedule> searchAllByNameContainingOrderByName (String name);

}
