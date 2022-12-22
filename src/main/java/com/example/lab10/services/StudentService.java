package com.example.lab10.services;

import com.example.lab10.entities.Student;
import com.example.lab10.repositories.StudentRepository;
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
public class StudentService {
    private StudentRepository repository;

    public Page<Student> getAll(@Min(0) Integer page, @Min(1) Integer elementsPerPage,
                                Sort.Direction sortDirection, StudentFields sortField) {
        Pageable pageable = PageRequest.of(page, elementsPerPage,
                Sort.by(sortDirection, sortField.name()));
        return repository.findAll(pageable);
    }

    public enum StudentFields {
        name, email, phone, surname
    }

    public List<Student> searchByNameAndSurname(@NotNull String name, @NotNull String surname) {
        return repository.searchAllByNameContainingOrSurnameContainingOrderBySurname(name, surname);
    }

    public Student getOneById(@Min(value = 1, message = "invalid id") Integer id) {
        Optional<Student> res = repository.findById(id);
        return res.orElse(null);
    }

    public Student addOne(@Valid Student input) {
        return repository.save(input);
    }

    public void deleteOne(@Min(value = 1, message = "invalid id") Integer id) {
        repository.deleteById(id);
    }

    public void updateOne(@Valid Student entity) {
        Optional<Student> entityFromDB = repository.findById(entity.getId());
        if (entityFromDB.isPresent()) {
            repository.save(entity);
        }

    }
}

