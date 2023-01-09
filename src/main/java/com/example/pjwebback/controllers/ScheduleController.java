package com.example.pjwebback.controllers;

import com.example.pjwebback.entities.Group;
import com.example.pjwebback.entities.Schedule;
import com.example.pjwebback.services.ScheduleService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/schedule")
@AllArgsConstructor
public class ScheduleController {
    private ScheduleService service;


    @GetMapping()
    public List<Schedule> getAll(@RequestParam(name = "group", required = false) Integer groupId,
                                 @RequestParam(name = "teacher", required = false) Integer teacherId,
                                 @RequestParam(name = "discipline", required = false) Integer disciplineId) {
        if (groupId != null) {
            return service.getAllByGroup(groupId);
        }
        if (teacherId != null) {
            return service.getAllByTeacher(teacherId);
        }
        if (disciplineId != null) {
            return service.getAllByDiscipline(disciplineId);
        }
        return service.getAll();
    }

    @GetMapping("/search")
    public List<Schedule> findByName(@RequestParam String name) {

        return service.searchByName(name);
    }
    @GetMapping("/{id}")
    public Schedule getOne(@PathVariable Integer id) {
        return service.getOneById(id);
    }

    @PostMapping
    Schedule addOne(@RequestBody Schedule entity) {
        return service.addOne(entity);
    }

    @PutMapping("/{id}")
    void updateOne(@RequestBody Schedule entity) {
        service.updateOne(entity);
    }

    @DeleteMapping("/{id}")
    void deleteOne(@PathVariable Integer id) {
        service.deleteOne(id);
    }
}
