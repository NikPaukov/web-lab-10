package com.example.lab10.controllers;

import com.example.lab10.entities.Faculty;
import com.example.lab10.services.FacultyService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/faculties")
@AllArgsConstructor
public class FacultyController {
    private FacultyService service;

    @GetMapping()
    public Page<Faculty> getAll(@RequestParam(required = false, defaultValue = "0") Integer page,
                                @RequestParam(required = false, defaultValue = "10") Integer elementsPerPage,
                                @RequestParam(required = false, defaultValue = "ASC") Sort.Direction sortDirection,
                                @RequestParam(required = false, defaultValue = "name") FacultyService.FacultyFields sortField
    ) {
        return service.getAll(page, elementsPerPage, sortDirection, sortField);
    }

    @GetMapping("/search/name")
    public List<Faculty> search(@RequestParam String name) {
        return service.searchByName(name);
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
    void deleteOne(@PathVariable Integer id) {
        service.deleteOne(id);
    }
}

