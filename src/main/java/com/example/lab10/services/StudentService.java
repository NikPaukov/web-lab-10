package com.example.lab10.services;
import com.example.lab10.entities.Student;
import com.example.lab10.repositories.StudentRepository;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class StudentService {
    private StudentRepository repository;

    public List<Student> getAll() {
        return repository.findAll();
    }

    public Student getOneById(@Min(value = 1,message = "invalid id") Integer id) {
        Optional<Student> res = repository.findById(id);
        return res.orElse(null);
    }

    public Student addOne(@Valid Student input) {
        return repository.save(input);
    }
    public List<Student> searchAllByName(String name){
        return repository.searchAllByName(name);
    }
    public void deleteOne(@Min(value = 1,message = "invalid id") Integer id) {
        repository.deleteById(id);
    }

    public void updateOne(@Valid Student entity) {
        Optional<Student> entityFromDB = repository.findById(entity.getId());
        if(entityFromDB.isPresent()){
            repository.save(entity);
        }

    }
}

