package com.example.lab10.controllers;

import com.example.lab10.entities.Faq;
import com.example.lab10.services.FaqService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/faq")
@AllArgsConstructor
public class FaqController {

    private FaqService service;

    @GetMapping()
    public Page<Faq> getAll(@RequestParam(required = false, defaultValue = "0") Integer page,
                            @RequestParam(required = false, defaultValue = "10") Integer elementsPerPage,
                            @RequestParam(required = false, defaultValue = "ASC") Sort.Direction sortDirection,
                            @RequestParam(required = false, defaultValue = "name") FaqService.FaqFields sortField) {
        return service.getAll(page, elementsPerPage, sortDirection, sortField);
    }

    @GetMapping("/search/question")
    public List<Faq> search(@RequestParam String question) {
        return service.searchByQuestion(question);
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
    void deleteOne(@PathVariable Integer id) {
        service.deleteOne(id);
    }
}
