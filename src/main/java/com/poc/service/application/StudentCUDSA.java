package com.poc.service.application;

import com.poc.model.dto.StudentDTO;
import com.poc.model.requests.StudentRequestDTO;

public interface StudentCUDSA {
    public StudentDTO saveStudent(StudentRequestDTO studentRequestDTO);
    public StudentDTO updateStudent(StudentDTO student);
    public void deleteStudent(Long id);
}
