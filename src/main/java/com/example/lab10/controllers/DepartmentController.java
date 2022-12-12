package com.example.lab10.controllers;

import com.example.lab10.entities.Department;
import com.example.lab10.services.DepartmentService;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")
@AllArgsConstructor
public class DepartmentController {
    private DepartmentService service;

    @GetMapping()
    public Page<Department> getAll(@RequestParam(required = false, defaultValue = "0") Integer page,
                                   @RequestParam(required = false, defaultValue = "10") Integer elementsPerPage,
                                   @RequestParam(required = false, defaultValue = "ASC") Sort.Direction sortDirection,
                                   @RequestParam(required = false, defaultValue = "name") DepartmentService.DepartmentFields sortField
                                   ) {
        return service.getAll(page, elementsPerPage,sortDirection, sortField);
    }
    @GetMapping("/search/name")
    public List<Department> search(@RequestParam String name){
        return service.searchByName(name);
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
