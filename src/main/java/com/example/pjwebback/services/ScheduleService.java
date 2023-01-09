package com.example.pjwebback.services;

import com.example.pjwebback.entities.*;
import com.example.pjwebback.exceptionHandling.NotFoundException;
import com.example.pjwebback.repositories.DepartmentRepository;
import com.example.pjwebback.repositories.ScheduleRepository;
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

    public Schedule getOneById(Integer id) {
        Optional<Schedule> res = repository.findById(id);
        if (res.isPresent()) {
            return res.get();
        } else {
            throw new NotFoundException("Schedule with id " + id + " doesnt exist");
        }
    }
    public List<Schedule> getAllByGroup(@Min(1) Integer groupId){
        Group group = groupService.getOneById(groupId);
        List<Schedule> res = repository.findAllByGroup(group);
        if (res.size()!=0) {
            return res;
        } else {
            throw new NotFoundException("Schedule for group " + group.getName() + " with id " +group.getId() + " doesnt exist");
        }    }
    public List<Schedule> getAllByTeacher(@Min(1) Integer teacherId){
        Teacher teacher = teacherService.getOneById(teacherId);
        List<Schedule> res = repository.findAllByTeacher(teacher);
        if (res.size()!=0) {
            return res;
        } else {
            throw new NotFoundException("Schedule for teacher " + teacher.getName() +" " + teacher.getSurname()
                    + " with id " +teacher.getId() + " doesnt exist");
        }    }
    public List<Schedule> searchByName( String name){
        return repository.searchAllByNameContains(name);
    }
    public List<Schedule> getAllByDiscipline(@Min(1) Integer disciplineId){
        Discipline discipline = disciplineService.getOneById(disciplineId);
        List<Schedule> res = repository.findAllByDiscipline(discipline);
        if (res.size()!=0) {
            return res;
        } else {
            throw new NotFoundException("Schedule for discipline " + discipline.getName()
                    + " with id " +discipline.getId() + " doesnt exist");
        }    }

    public Schedule addOne(@Valid Schedule input) {
         return repository.save(input);
    }

    public void deleteOne(Integer id) {
        repository.deleteById(id);
    }

    public void updateOne(@Valid Schedule entity) {
        Optional<Schedule> entityFromDB = repository.findById(entity.getId());
        if(entityFromDB.isPresent()){
            repository.save(entity);
        } else{
            throw new NotFoundException("Schedule with id \" + id + \" doesnt exist");
        }

    }
}

