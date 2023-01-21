package com.poc.service.application;

import com.poc.model.dto.StudentDTO;
import com.poc.utils.HelpPage;
import org.springframework.data.domain.Pageable;

public interface StudentRSA {
    public StudentDTO getStudentById(Long id);
    public HelpPage<StudentDTO> getAllStudents(String name, Pageable pageable);
}
