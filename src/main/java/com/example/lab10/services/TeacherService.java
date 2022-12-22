package com.example.lab10.services;

import com.example.lab10.entities.Teacher;
import com.example.lab10.repositories.TeacherRepository;
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
public class TeacherService {
    private TeacherRepository repository;

    public Page<Teacher> getAll(@Min(0) Integer page, @Min(1) Integer elementsPerPage,
                                Sort.Direction sortDirection, TeacherFields sortField) {
        Pageable pageable = PageRequest.of(page, elementsPerPage,
                Sort.by(sortDirection, sortField.name()));
        return repository.findAll(pageable);
    }

    public enum TeacherFields {
        name, email, phone, surname
    }

    public List<Teacher> searchByNameAndSurname(@NotNull String name, @NotNull String surname) {
        return repository.searchAllByNameContainingOrSurnameContainingOrderBySurname(name, surname);
    }

    public Teacher getOneById(@Min(value = 1, message = "invalid id") Integer id) {
        Optional<Teacher> res = repository.findById(id);
        return res.orElse(null);
    }

    public Teacher addOne(@Valid Teacher input) {
        return repository.save(input);
    }

    public void deleteOne(@Min(value = 1, message = "invalid id") Integer id) {
        repository.deleteById(id);
    }

    public void updateOne(@Valid Teacher entity) {
        Optional<Teacher> entityFromDB = repository.findById(entity.getId());
        if (entityFromDB.isPresent()) {
            repository.save(entity);
        }
    }
}

