package com.example.lab10.controllers;


import com.example.lab10.entities.Student;
import com.example.lab10.services.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
@AllArgsConstructor
public class StudentController {
    private StudentService service;
    @GetMapping("/search")
    public List<Student> seachByName(@RequestParam String name){
        return service.searchAllByName(name);
    }
    @GetMapping()
    public List<Student> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Student getOne(@PathVariable Integer id) {
        return service.getOneById(id);
    }

    @PostMapping
    Student addOne(@RequestBody Student entity) {
        return service.addOne(entity);
    }

    @PutMapping("/{id}")
    void updateOne(@RequestBody Student entity) {
        service.updateOne(entity);
    }
    @DeleteMapping("/{id}")
    void deleteOne(@PathVariable Integer id){
        service.deleteOne(id);
    }
}

