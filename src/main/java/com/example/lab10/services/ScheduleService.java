package com.example.lab10.services;

import com.example.lab10.entities.*;
import com.example.lab10.exceptionHandling.EntityNotFoundException;
import com.example.lab10.repositories.ScheduleRepository;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ScheduleService {
    private ScheduleRepository repository;
    private GroupService groupService;
    private TeacherService teacherService;
    private DisciplineService disciplineService;

    public Page<Schedule> getAll(@Min(0) Integer page, @Min(1) Integer elementsPerPage,
                                 Sort.Direction sortOrder, ScheduleFields sortField) {
        Pageable pageable = PageRequest.of(page, elementsPerPage,
                Sort.by(sortOrder, sortField.name()));
        return repository.findAll(pageable);
    }
    public Page<Schedule> getAllByDiscipline(@Min(value = 1, message = "invalid id") Integer disciplineId,
                                        @Min(0) Integer page, @Min(1) Integer elementsPerPage,
                                        Sort.Direction sortOrder, ScheduleFields sortField) {
        Pageable pageable = PageRequest.of(page, elementsPerPage,
                Sort.by(sortOrder, sortField.name()));
        Discipline discipline = disciplineService.getOneById(disciplineId);

        return repository.findAllByDiscipline(discipline, pageable);
    }


    public Page<Schedule> getAllByGroup(@Min(value = 1, message = "invalid id") Integer groupId,
                                        @Min(0) Integer page, @Min(1) Integer elementsPerPage,
                                        Sort.Direction sortOrder, ScheduleFields sortField) {
        Pageable pageable = PageRequest.of(page, elementsPerPage,
                Sort.by(sortOrder, sortField.name()));
        Group group = groupService.getOneById(groupId);

        return repository.findAllByGroup(group, pageable);
    }


    public Page<Schedule> getAllByTeacher(@Min(value = 1, message = "invalid id") Integer teacherId,
                                        @Min(0) Integer page, @Min(1) Integer elementsPerPage,
                                        Sort.Direction sortOrder, ScheduleFields sortField) {
        Pageable pageable = PageRequest.of(page, elementsPerPage,
                Sort.by(sortOrder, sortField.name()));
        Teacher teacher = teacherService.getOneById(teacherId);

        return repository.findAllByTeacher(teacher, pageable);
    }




    public enum ScheduleFields {
        name,
        lesson,
        dayOfWeek,
        classroom
    }

    public List<Schedule> searchByName(@NotNull String name) {
        return repository.searchAllByNameContainingOrderByName(name);
    }

    public Schedule getOneById(@Min(value = 1, message = "invalid id") Integer id) {
        Optional<Schedule> res = repository.findById(id);
        return res.orElse(null);
    }



    public Schedule addOne(@Valid Schedule input) {
        return repository.save(input);
    }

    public void deleteOne(@Min(value = 1, message = "invalid id") Integer id) {
        repository.deleteById(id);
    }

    public void updateOne(@Valid Schedule entity) {
        Optional<Schedule> entityFromDB = repository.findById(entity.getId());
        if (entityFromDB.isPresent()) {
            repository.save(entity);
        }

    }
}

