package com.example.lab10.controllers;

import com.example.lab10.entities.Discipline;
import com.example.lab10.services.DisciplineService;
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

