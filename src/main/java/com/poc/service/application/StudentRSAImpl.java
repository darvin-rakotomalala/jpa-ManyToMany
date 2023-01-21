package com.poc.service.application;

import com.poc.mapper.StudentMapper;
import com.poc.model.dto.StudentDTO;
import com.poc.service.business.StudentRSM;
import com.poc.utils.HelpPage;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class StudentRSAImpl implements StudentRSA {

    private final StudentRSM studentRSM;
    private final StudentMapper studentMapper;

    @Override
    public StudentDTO getStudentById(Long id) {
        return studentMapper.toDTO(studentRSM.getStudentById(id));
    }

    @Override
    public HelpPage<StudentDTO> getAllStudents(String name, Pageable pageable) {
        return studentMapper.toDTO(studentRSM.getAllStudents(name, pageable), pageable);
    }

}
