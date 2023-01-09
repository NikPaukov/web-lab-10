package com.example.pjwebback.services;
import com.example.pjwebback.entities.Department;
import com.example.pjwebback.entities.Teacher;
import com.example.pjwebback.exceptionHandling.NotFoundException;
import com.example.pjwebback.repositories.DepartmentRepository;
import com.example.pjwebback.repositories.TeacherRepository;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TeacherService {
    private TeacherRepository repository;

    public List<Teacher> getAll() {
        return repository.findAll();
    }

    public Teacher getOneById(Integer id) {
        Optional<Teacher> res = repository.findById(id);
        if (res.isPresent()) {
            return res.get();
        } else {
            throw new NotFoundException("Teacher with id " + id + " doesnt exist");
        }    }

    public Teacher addOne(@Valid Teacher input) {
        return  repository.save(input);
    }

    public void deleteOne(Integer id) {
        repository.deleteById(id);
    }

    public void updateOne(@Valid Teacher entity) {
        Optional<Teacher> entityFromDB = repository.findById(entity.getId());
        if(entityFromDB.isPresent()){
            repository.save(entity);
        } else{
            throw new NotFoundException("Teacher with id " + entity.getId() + " doesnt exist");
        }

    }
}

