package com.example.pjwebback.controllers;

import com.example.pjwebback.entities.Faculty;
import com.example.pjwebback.entities.Faq;
import com.example.pjwebback.services.FacultyService;
import com.example.pjwebback.services.FaqService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/faq")
@AllArgsConstructor
public class FaqController {
    private FaqService service;

    @GetMapping()
    public List<Faq> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Faq getOne(@PathVariable Integer id) {
        return service.getOneById(id);
    }

    @PostMapping
    Faq addOne(@RequestBody Faq entity) {
        return service.addOne(entity);
    }

    @PutMapping("/{id}")
    void updateOne(@RequestBody Faq entity) {
        service.updateOne(entity);
    }
    @DeleteMapping("/{id}")
    void deleteOne(@PathVariable Integer id){
        service.deleteOne(id);
    }
}
