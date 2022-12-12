package com.example.lab10.services;

import com.example.lab10.entities.Discipline;
import com.example.lab10.entities.Faculty;
import com.example.lab10.repositories.FacultyRepository;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class FacultyService {
    private FacultyRepository repository;


    public Page<Faculty> getAll(@Min(0) Integer page, @Min(1) Integer elementsPerPage,
                                   Sort.Direction sortDirection, FacultyFields sortField) {
        Pageable pageable = PageRequest.of(page, elementsPerPage,
                Sort.by(sortDirection, sortField.name()));
        return repository.findAll(pageable);
    }
    public enum FacultyFields{
        name,
        shortName
    }
    public List<Faculty> searchByName(@NotNull String name){
        return repository.searchAllByNameContainingOrderByName(name);
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

