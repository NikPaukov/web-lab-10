package com.example.lab10.repositories;

import com.example.lab10.entities.Discipline;
import com.example.lab10.entities.Group;
import com.example.lab10.entities.Schedule;
import com.example.lab10.entities.Teacher;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Integer> {
 List<Schedule> findAllByGroup(@NotNull Group group);
 List<Schedule> findAllByTeacher(@NotNull Teacher teacher);
 List<Schedule> findAllByDiscipline(@NotNull Discipline discipline);
 List<Schedule> searchAllByName(String name);
}
