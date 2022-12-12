package com.example.lab10.controllers;


import com.example.lab10.entities.Discipline;
import com.example.lab10.entities.Student;
import com.example.lab10.services.DisciplineService;
import com.example.lab10.services.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
@AllArgsConstructor
public class StudentController {
    private StudentService service;
    @GetMapping()
    public Page<Student> getAll(@RequestParam(required = false, defaultValue = "0") Integer page,
                                   @RequestParam(required = false, defaultValue = "10") Integer elementsPerPage,
                                   @RequestParam(required = false, defaultValue = "ASC") Sort.Direction sortDirection,
                                   @RequestParam(required = false, defaultValue = "name") StudentService.StudentFields sortField
    ) {
        return service.getAll(page, elementsPerPage,sortDirection, sortField);
    }
    @GetMapping("/search/name")
    public List<Student> search(@RequestParam(required = false,defaultValue = "") String name,
                                   @RequestParam(required = false, defaultValue = "") String surname){
        return service.searchByNameAndSurname(name, surname);
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

