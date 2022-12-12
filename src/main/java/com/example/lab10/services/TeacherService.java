package com.example.lab10.services;
import com.example.lab10.entities.Teacher;
import com.example.lab10.repositories.TeacherRepository;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
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

    public Teacher getOneById(@Min(value = 1,message = "invalid id") Integer id) {
        Optional<Teacher> res = repository.findById(id);
        return res.orElse(null);
    }

    public Teacher addOne(@Valid Teacher input) {
        return  repository.save(input);
    }

    public void deleteOne(@Min(value = 1,message = "invalid id") Integer id) {
        repository.deleteById(id);
    }

    public void updateOne(@Valid Teacher entity) {
        Optional<Teacher> entityFromDB = repository.findById(entity.getId());
        if(entityFromDB.isPresent()){
            repository.save(entity);
        }
    }
}

