package com.poc.controller;

import com.poc.model.dto.CourseListStudentDTO;
import com.poc.service.application.CourseRSA;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "courses")
public class CourseController {

    private final CourseRSA courseRSA;

    @Operation(summary = "WS used to get list students by course name")
    @GetMapping
    public CourseListStudentDTO getByCourseName(@RequestParam(name = "name", required = true) String courseName) {
        return courseRSA.getByName(courseName);
    }

}
