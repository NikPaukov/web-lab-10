package com.example.lab10.controllers;

import com.example.lab10.entities.Department;
import com.example.lab10.entities.Discipline;
import com.example.lab10.services.DepartmentService;
import com.example.lab10.services.DisciplineService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/disciplines")
@AllArgsConstructor
public class DisciplineController {
    private DisciplineService service;

    @GetMapping()
    public Page<Discipline> getAll(@RequestParam(required = false, defaultValue = "0") Integer page,
                                   @RequestParam(required = false, defaultValue = "10") Integer elementsPerPage,
                                   @RequestParam(required = false, defaultValue = "ASC") Sort.Direction sortDirection,
                                   @RequestParam(required = false, defaultValue = "name") DisciplineService.DisciplineFields sortField
    ) {
        return service.getAll(page, elementsPerPage,sortDirection, sortField);
    }
    @GetMapping("/search/name")
    public List<Discipline> search(@RequestParam String name){
        return service.searchByName(name);
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

