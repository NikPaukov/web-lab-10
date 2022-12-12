package com.example.lab10.controllers;

import com.example.lab10.entities.Schedule;
import com.example.lab10.services.DepartmentService;
import com.example.lab10.services.ScheduleService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/schedules")
@AllArgsConstructor
public class ScheduleController {
    private ScheduleService service;


    @GetMapping("/by/group")
    public Page<Schedule> searchByGroup(@RequestParam(required = false, defaultValue = "0") Integer page,
                                        @RequestParam(required = false, defaultValue = "10") Integer elementsPerPage,
                                        @RequestParam(required = false, defaultValue = "ASC") Sort.Direction sortDirection,
                                        @RequestParam(required = false, defaultValue = "name") ScheduleService.ScheduleFields sortField
            , @RequestParam(name = "group", required = false) Integer groupId) {
        return service.getAllByGroup(groupId, page, elementsPerPage, sortDirection, sortField);
    }

    @GetMapping("/by/teacher")
    public Page<Schedule> searchByTeacher(@RequestParam(name = "teacher", required = false) Integer teacherId,
                                          @RequestParam(required = false, defaultValue = "0") Integer page,
                                          @RequestParam(required = false, defaultValue = "10") Integer elementsPerPage,
                                          @RequestParam(required = false, defaultValue = "ASC") Sort.Direction sortDirection,
                                          @RequestParam(required = false, defaultValue = "name") ScheduleService.ScheduleFields sortField
    ) {
        return service.getAllByTeacher(teacherId, page, elementsPerPage, sortDirection, sortField);
    }

    @GetMapping("/by/discipline")
    public Page<Schedule> searchByDiscipline(@RequestParam(name = "group", required = false) Integer groupId,
                                        @RequestParam(required = false, defaultValue = "0") Integer page,
                                        @RequestParam(required = false, defaultValue = "10") Integer elementsPerPage,
                                        @RequestParam(required = false, defaultValue = "ASC") Sort.Direction sortDirection,
                                        @RequestParam(required = false, defaultValue = "name") ScheduleService.ScheduleFields sortField
    ) {
        return service.getAllByDiscipline(groupId,page,elementsPerPage,sortDirection,sortField);
    }

    @GetMapping()
    public Page<Schedule> getAll(@RequestParam(required = false, defaultValue = "0") Integer page,
                                 @RequestParam(required = false, defaultValue = "10") Integer elementsPerPage,
                                 @RequestParam(required = false, defaultValue = "ASC") Sort.Direction sortDirection,
                                 @RequestParam(required = false, defaultValue = "name") ScheduleService.ScheduleFields sortField
    ) {

        return service.getAll(page, elementsPerPage, sortDirection, sortField);
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
