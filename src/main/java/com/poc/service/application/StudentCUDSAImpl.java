package com.poc.service.application;

import com.poc.mapper.CourseMapper;
import com.poc.mapper.StudentMapper;
import com.poc.model.dto.CourseDTO;
import com.poc.model.dto.StudentDTO;
import com.poc.model.requests.StudentRequestDTO;
import com.poc.service.business.CourseRSM;
import com.poc.service.business.StudentCUDSM;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@RequiredArgsConstructor
@Service
public class StudentCUDSAImpl implements StudentCUDSA {

    private final StudentCUDSM studentCUDSM;
    private final CourseRSM courseRSM;
    private final StudentMapper studentMapper;
    private final CourseMapper courseMapper;

    @Override
    public StudentDTO saveStudent(StudentRequestDTO studentRequestDTO) {
        StudentDTO newStudent = new StudentDTO();
        newStudent.setName(studentRequestDTO.getName());
        Set<CourseDTO> studentCourses = new HashSet<>();
        studentRequestDTO.getCourses().forEach(c -> {
            CourseDTO courseFound = courseMapper.toDTO(courseRSM.getByName(c));
            if (courseFound == null) {
                CourseDTO newCourse = new CourseDTO();
                newCourse.setName(c);
                studentCourses.add(newCourse);
            }
            studentCourses.add(courseFound);
        });
        newStudent.setCourses(studentCourses);
        return studentMapper.toDTO(studentCUDSM.addStudent(studentMapper.toDO(newStudent)));
    }

    @Override
    public StudentDTO updateStudent(StudentDTO student) {
        return studentMapper.toDTO(studentCUDSM.updateStudent(studentMapper.toDO(student)));
    }

    @Override
    public void deleteStudent(Long id) {
        studentCUDSM.deleteStudent(id);
    }

}
