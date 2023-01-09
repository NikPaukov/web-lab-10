package com.example.pjwebback.services;
import com.example.pjwebback.entities.Department;
import com.example.pjwebback.entities.Discipline;
import com.example.pjwebback.exceptionHandling.NotFoundException;
import com.example.pjwebback.repositories.DepartmentRepository;
import com.example.pjwebback.repositories.DisciplineRepository;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Validated
public class DisciplineService {
    private DisciplineRepository repository;

    public List<Discipline> getAll() {
        return repository.findAll();
    }

    public Discipline getOneById(Integer id) {
        Optional<Discipline> res = repository.findById(id);
        if (res.isPresent()) {
            return res.get();
        } else {
            throw new NotFoundException("Discipline with id " + id + " doesnt exist");
        }
    }

    public Discipline addOne(@Valid Discipline input) {
         return repository.save(input);
    }

    public void deleteOne(Integer id) {
        repository.deleteById(id);
    }

    public void updateOne(@Valid Discipline entity) {
        Optional<Discipline> entityFromDB = repository.findById(entity.getId());
        if(entityFromDB.isPresent()){
            repository.save(entity);
        } else{
            throw new NotFoundException("Discipline with id " + entity.getId() + " doesnt exist");
        }

    }
}

