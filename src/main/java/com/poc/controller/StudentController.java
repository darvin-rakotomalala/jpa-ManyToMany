package com.poc.controller;

import com.poc.constraint.validation.StudentValidator;
import com.poc.model.dto.StudentDTO;
import com.poc.model.requests.StudentRequestDTO;
import com.poc.service.application.StudentCUDSA;
import com.poc.service.application.StudentRSA;
import com.poc.utils.HelpPage;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "students")
public class StudentController {

    private final StudentCUDSA studentCUDSA;
    private final StudentRSA studentRSA;
    private final StudentValidator studentValidator;

    @InitBinder("studentRequestDTO")
    protected void initStudentRequestDTOBinder(WebDataBinder webDataBinder) {
        webDataBinder.setValidator(studentValidator);
    }

    @Operation(summary = "WS used to save student")
    @PostMapping
    public StudentDTO saveStudent(@RequestBody @Validated StudentRequestDTO studentRequestDTO) {
        return studentCUDSA.saveStudent(studentRequestDTO);
    }

    @Operation(summary = "WS used to get all students")
    @GetMapping
    public HelpPage<StudentDTO> getAllStudents(
            @RequestParam(name = "name", required = false) String name,
            @RequestParam(defaultValue = "0", required = false) int page,
            @RequestParam(defaultValue = "15", required = false) int size) {

        Pageable pageable = PageRequest.of(page, size);
        return studentRSA.getAllStudents(name, pageable);
    }

    @Operation(summary = "WS used to get student by id")
    @GetMapping("/{id}")
    public StudentDTO getStudentById(@PathVariable("id") Long id) {
        return studentRSA.getStudentById(id);
    }

    @Operation(summary = "WS used to update student")
    @PutMapping
    public StudentDTO updateStudent(@RequestBody @Validated StudentDTO student) {
        return studentCUDSA.updateStudent(student);
    }

    @Operation(summary = "WS used to delete student by id")
    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable("id") Long id) {
        studentCUDSA.deleteStudent(id);
        return "Student with this id " + id + " deleted successfully !";
    }

}
