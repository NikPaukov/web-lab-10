package com.example.pjwebback.controllers;

import com.example.pjwebback.entities.Faculty;
import com.example.pjwebback.services.FacultyService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/faculty")
@AllArgsConstructor
public class FacultyController {
    private FacultyService service;

    @GetMapping()
    public List<Faculty> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Faculty getOne(@PathVariable Integer id) {
        return service.getOneById(id);
    }

    @PostMapping
    Faculty addOne(@RequestBody Faculty entity) {
        return service.addOne(entity);
    }

    @PutMapping("/{id}")
    void updateOne(@RequestBody Faculty entity) {
        service.updateOne(entity);
    }
    @DeleteMapping("/{id}")
    void deleteOne(@PathVariable Integer id){
        service.deleteOne(id);
    }
}

