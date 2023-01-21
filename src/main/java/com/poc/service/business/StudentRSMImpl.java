package com.poc.service.business;

import com.poc.exception.ErrorsEnum;
import com.poc.exception.FunctionalException;
import com.poc.model.domain.Student;
import com.poc.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class StudentRSMImpl implements StudentRSM {

    private final StudentRepository studentRepository;

    @Override
    public Student getStudentById(Long id) {
        try {
            log.info("----- getStudentById : {}", id);
            Optional<Student> studentFound = studentRepository.findById(id);
            if (studentFound.isEmpty()) {
                throw new FunctionalException(ErrorsEnum.ERR_MCS_STUDENT_NOT_FOUND.getErrorMessage());
            }
            return studentFound.get();
        } catch (Exception e) {
            log.error("Error getStudentById : {} {}", e.getMessage(), e);
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public Page<Student> getAllStudents(String name, Pageable pageable) {
        try {
            log.info("----- getAllStudents : {}", name);
            if (StringUtils.isBlank(name)) {
                return studentRepository.findAll(pageable);
            } else {
                return studentRepository.findByName(name, pageable);
            }
        } catch (Exception e) {
            log.error("Error getAllStudents : {} {}", e.getMessage(), e);
            e.printStackTrace();
            throw e;
        }
    }

}
