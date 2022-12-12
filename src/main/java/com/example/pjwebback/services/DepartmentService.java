package com.example.pjwebback.services;

import com.example.pjwebback.entities.Department;
import com.example.pjwebback.repositories.DepartmentRepository;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
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

    public Department getOneById(@Min(value = 1,message = "invalid id")Integer id) {
        Optional<Department> res = repository.findById(id);
        return res.orElse(null);
    }

    public Department addOne(@Valid Department input) {
         return repository.save(input);
    }

    public void deleteOne(@Min(value = 1,message = "invalid id")Integer id) {
        repository.deleteById(id);
    }

    public void updateOne(@Valid Department entity) {
        Optional<Department> entityFromDB = repository.findById(entity.getId());
        if(entityFromDB.isPresent()){
            repository.save(entity);
        }
    }
}
