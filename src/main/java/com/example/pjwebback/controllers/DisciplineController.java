package com.example.pjwebback.controllers;

import com.example.pjwebback.entities.Department;
import com.example.pjwebback.entities.Discipline;
import com.example.pjwebback.services.DepartmentService;
import com.example.pjwebback.services.DisciplineService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/discipline")
@AllArgsConstructor
public class DisciplineController {
    private DisciplineService service;

    @GetMapping()
    public List<Discipline> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Discipline getOne( @PathVariable Integer id) {
        return service.getOneById(id);
    }

    @PostMapping
    Discipline addOne( @RequestBody Discipline entity) {
        return service.addOne(entity);
    }

    @PutMapping("/{id}")
    void updateOne(@RequestBody Discipline entity) {
        service.updateOne(entity);
    }
    @DeleteMapping("/{id}")
    void deleteOne(@PathVariable Integer id){
        service.deleteOne(id);
    }
}

