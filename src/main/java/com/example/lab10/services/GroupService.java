package com.example.lab10.services;
import com.example.lab10.entities.Discipline;
import com.example.lab10.entities.Group;
import com.example.lab10.repositories.GroupRepository;
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
public class GroupService {
    private GroupRepository repository;


    public Page<Group> getAll(@Min(0) Integer page, @Min(1) Integer elementsPerPage,
                                   Sort.Direction sortDirection, GroupFields sortField) {
        Pageable pageable = PageRequest.of(page, elementsPerPage,
                Sort.by(sortDirection, sortField.name()));
        return repository.findAll(pageable);
    }
    public enum GroupFields{
        name,course
    }
    public List<Group> searchByName(@NotNull String name){
        return repository.searchAllByNameContainingOrderByName(name);
    }

    public Group getOneById(@Min(value = 1,message = "invalid id") Integer id) {
        Optional<Group> res = repository.findById(id);
        return res.orElse(null);
    }

    public Group addOne(@Valid Group input) {
        return repository.save(input);
    }

    public void deleteOne(@Min(value = 1,message = "invalid id") Integer id) {
        repository.deleteById(id);
    }

    public void updateOne(@Valid Group entity) {
        Optional<Group> entityFromDB = repository.findById(entity.getId());
        if(entityFromDB.isPresent()){
            repository.save(entity);
        }

    }
}

