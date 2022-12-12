package com.example.lab10.services;

import com.example.lab10.entities.*;
import com.example.lab10.exceptionHandling.EntityNotFoundException;
import com.example.lab10.repositories.ScheduleRepository;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
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
    public List<Schedule> getAll() {
        return repository.findAll();
    }

    public Schedule getOneById(@Min(value = 1,message = "invalid id") Integer id) {
        Optional<Schedule> res = repository.findById(id);
        return res.orElse(null);
    }
    public List<Schedule> getAllByGroup(@Min(value = 1,message = "invalid id") Integer groupId){
        Group group = groupService.getOneById(groupId);
        List<Schedule> res = repository.findAllByGroup(group);
        if (res.size()!=0) {
            return res;
        } else {
            throw new EntityNotFoundException("Schedule for group " + group.getName()+ " doesnt exist");
        }    }
    public List<Schedule> getAllByTeacher(@Min(value = 1,message = "invalid id") Integer teacherId){
        Teacher teacher = teacherService.getOneById(teacherId);
        List<Schedule> res = repository.findAllByTeacher(teacher);
        if (res.size()!=0) {
            return res;
        } else {
            throw new EntityNotFoundException("Schedule for teacher " + teacher.getName() + " doesnt exist");
        }    }
    public List<Schedule> searchByName( String name){
        return repository.searchAllByName(name);
    }
    public List<Schedule> getAllByDiscipline(@Min(value = 1,message = "invalid id") Integer disciplineId){
        Discipline discipline = disciplineService.getOneById(disciplineId);
        List<Schedule> res = repository.findAllByDiscipline(discipline);
        if (res.size()!=0) {
            return res;
        } else {
            throw new EntityNotFoundException("Schedule for discipline " + discipline.getName()
                     + " doesnt exist");
        }    }

    public Schedule addOne(@Valid Schedule input) {
         return repository.save(input);
    }

    public void deleteOne(@Min(value = 1,message = "invalid id") Integer id) {
        repository.deleteById(id);
    }

    public void updateOne(@Valid Schedule entity) {
        Optional<Schedule> entityFromDB = repository.findById(entity.getId());
        if(entityFromDB.isPresent()){
            repository.save(entity);
        }

    }
}

