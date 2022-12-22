package com.example.lab10.controllers;

import com.example.lab10.entities.Group;
import com.example.lab10.services.GroupService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/groups")
@AllArgsConstructor
public class GroupController {

    private GroupService service;

    @GetMapping()
    public Page<Group> getAll(@RequestParam(required = false, defaultValue = "0") Integer page,
                              @RequestParam(required = false, defaultValue = "10") Integer elementsPerPage,
                              @RequestParam(required = false, defaultValue = "ASC") Sort.Direction sortDirection,
                              @RequestParam(required = false, defaultValue = "name") GroupService.GroupFields sortField
    ) {
        return service.getAll(page, elementsPerPage, sortDirection, sortField);
    }

    @GetMapping("/search/name")
    public List<Group> search(@RequestParam String name) {
        return service.searchByName(name);
    }

    @GetMapping("/{id}")
    public Group getOne(@PathVariable Integer id) {
        return service.getOneById(id);
    }

    @PostMapping
    Group addOne(@RequestBody Group entity) {
        return service.addOne(entity);
    }

    @PutMapping("/{id}")
    void updateOne(@RequestBody Group entity) {
        service.updateOne(entity);
    }

    @DeleteMapping("/{id}")
    void deleteOne(@PathVariable Integer id) {
        service.deleteOne(id);
    }
}

