package com.example.pjwebback.services;
import com.example.pjwebback.entities.Department;
import com.example.pjwebback.entities.Group;
import com.example.pjwebback.exceptionHandling.NotFoundException;
import com.example.pjwebback.repositories.DepartmentRepository;
import com.example.pjwebback.repositories.GroupRepository;
import jakarta.validation.Valid;
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

    public Group getOneById(Integer id) {
        Optional<Group> res = repository.findById(id);
        if (res.isPresent()) {
            return res.get();
        } else {
            throw new NotFoundException("Group with id " + id + " doesnt exist");
        }    }

    public List<Group> searchAllByName(String name){
        return repository.searchAllByNameContaining(name);
    }
    public Group addOne(@Valid Group input) {
        return repository.save(input);
    }

    public void deleteOne(Integer id) {
        repository.deleteById(id);
    }

    public void updateOne(@Valid Group entity) {
        Optional<Group> entityFromDB = repository.findById(entity.getId());
        if(entityFromDB.isPresent()){
            repository.save(entity);
        } else{
            throw new NotFoundException("Group with id " + entity.getId() + " doesnt exist");
        }

    }
}

