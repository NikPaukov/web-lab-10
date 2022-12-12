package com.example.lab10.controllers;

import com.example.lab10.entities.Student;
import com.example.lab10.entities.Teacher;
import com.example.lab10.services.StudentService;
import com.example.lab10.services.TeacherService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teachers")
@AllArgsConstructor
public class TeacherController {
    private TeacherService service;
    @GetMapping()
    public Page<Teacher> getAll(@RequestParam(required = false, defaultValue = "0") Integer page,
                                @RequestParam(required = false, defaultValue = "10") Integer elementsPerPage,
                                @RequestParam(required = false, defaultValue = "ASC") Sort.Direction sortDirection,
                                @RequestParam(required = false, defaultValue = "name") TeacherService.TeacherFields sortField
    ) {
        return service.getAll(page, elementsPerPage,sortDirection, sortField);
    }
    @GetMapping("/search/name")
    public List<Teacher> search(@RequestParam(required = false,defaultValue = "") String name,
                                @RequestParam(required = false,defaultValue = "") String surname){
        return service.searchByNameAndSurname(name, surname);
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

