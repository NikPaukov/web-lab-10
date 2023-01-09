package com.example.pjwebback.services;
import com.example.pjwebback.entities.Department;
import com.example.pjwebback.entities.Student;
import com.example.pjwebback.exceptionHandling.NotFoundException;
import com.example.pjwebback.repositories.DepartmentRepository;
import com.example.pjwebback.repositories.StudentRepository;
import jakarta.validation.Valid;
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

    public Student getOneById(Integer id) {
        Optional<Student> res = repository.findById(id);
        if (res.isPresent()) {
            return res.get();
        } else {
            throw new NotFoundException("Student with id " + id + " doesnt exist");
        }    }

    public Student addOne(@Valid Student input) {
        return repository.save(input);
    }
    public List<Student> searchAllByName(String name){
        return repository.searchAllByNameContaining(name);
    }
    public void deleteOne(Integer id) {
        repository.deleteById(id);
    }

    public void updateOne(@Valid Student entity) {
        Optional<Student> entityFromDB = repository.findById(entity.getId());
        if(entityFromDB.isPresent()){
            repository.save(entity);
        } else{
            throw new NotFoundException("Student with id " + entity.getId() + " doesnt exist");
        }

    }
}

