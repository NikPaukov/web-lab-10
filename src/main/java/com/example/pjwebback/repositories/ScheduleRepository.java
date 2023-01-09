package com.example.pjwebback.repositories;

import com.example.pjwebback.entities.Discipline;
import com.example.pjwebback.entities.Group;
import com.example.pjwebback.entities.Schedule;
import com.example.pjwebback.entities.Teacher;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Integer> {
 List<Schedule> findAllByGroup(@NotNull Group group);
 List<Schedule> findAllByTeacher(@NotNull Teacher teacher);
 List<Schedule> findAllByDiscipline(@NotNull Discipline discipline);
 List<Schedule> searchAllByNameContains(String name);
}
