package com.poc.service.business;

import com.poc.model.domain.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface StudentRSM {
    public Student getStudentById(Long id);
    public Page<Student> getAllStudents(String name, Pageable pageable);
}
