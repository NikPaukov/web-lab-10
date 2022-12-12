package com.example.pjwebback.services;
import com.example.pjwebback.entities.Group;
import com.example.pjwebback.repositories.GroupRepository;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class GroupService {
    private GroupRepository repository;

    public List<Group> getAll() {
        return repository.findAll();
    }

    public Group getOneById(@Min(value = 1,message = "invalid id") Integer id) {
        Optional<Group> res = repository.findById(id);
        return res.orElse(null);
    }

    public List<Group> searchAllByName( String name){
        return repository.searchAllByName(name);
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

