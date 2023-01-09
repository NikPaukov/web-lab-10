package com.example.pjwebback.controllers;

import com.example.pjwebback.entities.Department;
import com.example.pjwebback.entities.Teacher;
import com.example.pjwebback.services.TeacherService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teacher")
@AllArgsConstructor
public class TeacherController {
    private TeacherService service;

    @GetMapping()
    public List<Teacher> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Teacher getOne(@PathVariable Integer id) {
        return service.getOneById(id);
    }

    @PostMapping
    Teacher addOne(@RequestBody Teacher entity) {
        return service.addOne(entity);
    }

    @PutMapping("/{id}")
    void updateOne(@RequestBody Teacher entity) {
        service.updateOne(entity);
    }
    @DeleteMapping("/{id}")
    void deleteOne(@PathVariable Integer id){
        service.deleteOne(id);
    }
}

