package com.example.pjwebback.services;

import com.example.pjwebback.entities.Faculty;
import com.example.pjwebback.repositories.FacultyRepository;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
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

    public Faculty getOneById(@Min(value = 1,message = "invalid id") Integer id) {
        Optional<Faculty> res = repository.findById(id);
        return res.orElse(null);
    }

    public Faculty addOne(@Valid Faculty input) {
         return repository.save(input);
    }

    public void deleteOne(@Min(value = 1,message = "invalid id") Integer id) {
        repository.deleteById(id);
    }

    public void updateOne(@Valid Faculty entity) {
        Optional<Faculty> entityFromDB = repository.findById(entity.getId());
        if(entityFromDB.isPresent()){
            repository.save(entity);
        }
    }
}

