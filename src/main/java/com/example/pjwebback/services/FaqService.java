package com.example.pjwebback.services;

import com.example.pjwebback.entities.Faq;
import com.example.pjwebback.entities.Group;
import com.example.pjwebback.exceptionHandling.NotFoundException;
import com.example.pjwebback.repositories.FaqRepository;
import com.example.pjwebback.repositories.GroupRepository;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class FaqService {
    private FaqRepository repository;

    public List<Faq> getAll() {
        return repository.findAll();
    }

    public Faq getOneById(Integer id) {
        Optional<Faq> res = repository.findById(id);
        if (res.isPresent()) {
            return res.get();
        } else {
            throw new NotFoundException("Faq with id " + id + " doesnt exist");
        }    }

    public Faq addOne(@Valid Faq input) {
        return repository.save(input);
    }

    public void deleteOne(Integer id) {
        repository.deleteById(id);
    }

    public void updateOne(@Valid Faq entity) {
        Optional<Faq> entityFromDB = repository.findById(entity.getId());
        if(entityFromDB.isPresent()){
            repository.save(entity);
        } else{
            throw new NotFoundException("Faq with id " + entity.getId() + " doesnt exist");
        }

    }
}
