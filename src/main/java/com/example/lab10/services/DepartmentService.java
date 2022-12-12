package com.example.lab10.services;

import com.example.lab10.entities.Department;
import com.example.lab10.repositories.DepartmentRepository;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Validated
public class DepartmentService {
    private DepartmentRepository repository;

    public Page<Department> getAll(@Min(0) Integer page,@Min(1) Integer elementsPerPage,
                                   Sort.Direction sortOrder, DepartmentFields sortField) {
          Pageable pageable = PageRequest.of(page, elementsPerPage,
                Sort.by(sortOrder, sortField.name()));
        return repository.findAll(pageable);
    }
    public enum DepartmentFields{
        name,
        shortName
    }
    public List<Department> searchByName(@NotNull String name){
        return repository.searchAllByNameContainingOrderByName(name);
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
