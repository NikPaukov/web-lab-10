package com.example.lab10.controllers;

import com.example.lab10.entities.Group;
import com.example.lab10.services.GroupService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/group")
@AllArgsConstructor
public class GroupController {

    private GroupService service;
    @GetMapping()
    public List<Group> getAll() {
        return service.getAll();
    }

    @GetMapping("/search")
    public List<Group> seachByName(@RequestParam String name){
        return service.searchAllByName(name);
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
    void deleteOne(@PathVariable Integer id){
        service.deleteOne(id);
    }
}

