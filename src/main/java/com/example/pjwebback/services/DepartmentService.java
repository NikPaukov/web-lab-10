package com.example.pjwebback.services;

import com.example.pjwebback.entities.Department;
import com.example.pjwebback.entities.Schedule;
import com.example.pjwebback.exceptionHandling.NotFoundException;
import com.example.pjwebback.repositories.DepartmentRepository;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Validated
public class DepartmentService {
    private DepartmentRepository repository;

    public List<Department> getAll() {
        return repository.findAll();
    }

    public Department getOneById(Integer id) {
        Optional<Department> res = repository.findById(id);
        if (res.isPresent()) {
            return res.get();
        } else {
            throw new NotFoundException("Department with id " + id + " doesnt exist");
        }
    }

    public Department addOne(@Valid Department input) {
         return repository.save(input);
    }

    public void deleteOne(Integer id) {
        repository.deleteById(id);
    }

    public void updateOne(@Valid Department entity) {
        Optional<Department> entityFromDB = repository.findById(entity.getId());
        if(entityFromDB.isPresent()){
            repository.save(entity);
        } else{
            throw new NotFoundException("Department with id " + entity.getId() + " doesnt exist");
        }

    }
}
