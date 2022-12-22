package com.example.lab10.services;

import com.example.lab10.entities.Discipline;
import com.example.lab10.repositories.DisciplineRepository;
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
public class DisciplineService {
    private DisciplineRepository repository;

    public Page<Discipline> getAll(@Min(0) Integer page, @Min(1) Integer elementsPerPage,
                                   Sort.Direction sortDirection, DisciplineFields sortField) {
        Pageable pageable = PageRequest.of(page, elementsPerPage,
                Sort.by(sortDirection, sortField.name()));
        return repository.findAll(pageable);
    }

    public enum DisciplineFields {
        name
    }

    public List<Discipline> searchByName(@NotNull String name) {
        return repository.searchAllByNameContainingOrderByName(name);
    }


    public List<Discipline> getAll() {
        return repository.findAll();
    }

    public Discipline getOneById(@Min(value = 1, message = "invalid id") Integer id) {
        Optional<Discipline> res = repository.findById(id);
        return res.orElse(null);
    }

    public Discipline addOne(@Valid Discipline input) {
        return repository.save(input);
    }

    public void deleteOne(@Min(value = 1, message = "invalid id") Integer id) {
        repository.deleteById(id);
    }

    public void updateOne(@Valid Discipline entity) {
        Optional<Discipline> entityFromDB = repository.findById(entity.getId());
        if (entityFromDB.isPresent()) {
            repository.save(entity);
        }

    }
}

