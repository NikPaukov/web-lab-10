package com.example.lab10.services;

import com.example.lab10.entities.Faq;
import com.example.lab10.repositories.FaqRepository;
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
public class FaqService {
    private FaqRepository repository;

    public Page<Faq> getAll(@Min(0) Integer page, @Min(1) Integer elementsPerPage,
                            Sort.Direction sortDirection, FaqFields sortField) {
        Pageable pageable = PageRequest.of(page, elementsPerPage, Sort.by(sortDirection, sortField.name()));
        return repository.findAll(pageable);
    }

    public enum FaqFields {
        question, answer
    }

    public List<Faq> searchByQuestion(@NotNull String question) {
        return repository.searchAllByQuestionContainingOrderByQuestion(question);
    }

    public Faq addOne(@Valid Faq input) {
        return repository.save(input);
    }

    public void deleteOne(@Min(value = 1, message = "invalid id") Integer id) {
        repository.deleteById(id);
    }

    public void updateOne(@Valid Faq entity) {
        Optional<Faq> entityFromDB = repository.findById(entity.getId());
        if (entityFromDB.isPresent()) {
            repository.save(entity);
        }
    }
}
