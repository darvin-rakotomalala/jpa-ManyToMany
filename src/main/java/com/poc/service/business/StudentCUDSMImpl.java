package com.poc.service.business;

import com.poc.exception.ErrorsEnum;
import com.poc.exception.FunctionalException;
import com.poc.model.domain.Course;
import com.poc.model.domain.Student;
import com.poc.repository.CourseRepository;
import com.poc.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Slf4j
@RequiredArgsConstructor
@Service
public class StudentCUDSMImpl implements StudentCUDSM {

    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;
    private final StudentRSM studentRSM;

    @Transactional
    @Override
    public Student addStudent(Student student) {
        try {
            log.info("----- addStudent");
            return studentRepository.save(student);
        } catch (Exception e) {
            log.error("Error addStudent : {} {}", e.getMessage(), e);
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public Student updateStudent(Student student) {
        try {
            log.info("----- updateStudent");
            if (student == null || student.getId() == null) {
                throw new FunctionalException(ErrorsEnum.ERR_MCS_STUDENT_ID_EMPTY.getErrorMessage());
            }
            Student studentFound = studentRSM.getStudentById(student.getId());
            studentFound.getCourses().clear();
            studentFound.setName(student.getName());
            studentFound.setCourses(student.getCourses());
            return studentRepository.save(studentFound);
        } catch (Exception e) {
            log.error("Error updateStudent : {} {}", e.getMessage(), e);
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void deleteStudent(Long id) {
        try {
            log.info("----- deleteStudent : {}", id);
            Student studentFound = studentRSM.getStudentById(id);
            // Remove the related courses from student entity.
            if (studentFound != null) {
                studentFound.removeCourses();
                studentRepository.deleteById(studentFound.getId());
            }
        } catch (Exception e) {
            log.error("Error deleteStudent : {} {}", e.getMessage(), e);
            e.printStackTrace();
            throw e;
        }
    }
}
