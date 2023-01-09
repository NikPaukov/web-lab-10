package com.example.pjwebback.services;

import com.example.pjwebback.entities.Department;
import com.example.pjwebback.entities.Faculty;
import com.example.pjwebback.exceptionHandling.NotFoundException;
import com.example.pjwebback.repositories.DepartmentRepository;
import com.example.pjwebback.repositories.FacultyRepository;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class FacultyService {
    private FacultyRepository repository;

    public List<Faculty> getAll() {
        return repository.findAll();
    }

    public Faculty getOneById(Integer id) {
        Optional<Faculty> res = repository.findById(id);
        if (res.isPresent()) {
            return res.get();
        } else {
            throw new NotFoundException("Faculty with id " + id + " doesnt exist");
        }    }

    public Faculty addOne(@Valid Faculty input) {
         return repository.save(input);
    }

    public void deleteOne(Integer id) {
        repository.deleteById(id);
    }

    public void updateOne(@Valid Faculty entity) {
        Optional<Faculty> entityFromDB = repository.findById(entity.getId());
        if(entityFromDB.isPresent()){
            repository.save(entity);
        } else{
            throw new NotFoundException("Faculty with id " + entity.getId() + " doesnt exist");
        }

    }
}

