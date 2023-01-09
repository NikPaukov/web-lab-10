package com.example.pjwebback.controllers;


import com.example.pjwebback.entities.Department;
import com.example.pjwebback.entities.Student;
import com.example.pjwebback.services.StudentService;
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

