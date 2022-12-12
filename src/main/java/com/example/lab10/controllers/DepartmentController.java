package com.example.lab10.controllers;

import com.example.lab10.entities.Department;
import com.example.lab10.services.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
@AllArgsConstructor
public class DepartmentController {
    private DepartmentService service;

    @GetMapping()
    public List<Department> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Department getOne(@PathVariable Integer id) {
        return service.getOneById(id);
    }

    @PostMapping
    Department addOne(@RequestBody Department entity) {
         return service.addOne(entity);
    }

    @PutMapping("/{id}")
    void updateOne(@RequestBody Department entity) {
        service.updateOne(entity);
    }
    @DeleteMapping("/{id}")
    void deleteOne(@PathVariable Integer id){
        service.deleteOne(id);
    }
}
