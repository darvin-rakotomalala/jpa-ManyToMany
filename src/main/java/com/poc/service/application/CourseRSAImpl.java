package com.poc.service.application;

import com.poc.exception.ErrorsEnum;
import com.poc.exception.FunctionalException;
import com.poc.mapper.CourseListStudentMapper;
import com.poc.model.dto.CourseListStudentDTO;
import com.poc.service.business.CourseRSM;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CourseRSAImpl implements CourseRSA {

    private final CourseRSM courseRSM;
    private final CourseListStudentMapper courseMapper;

    @Override
    public CourseListStudentDTO getByName(String courseName) {
        CourseListStudentDTO courseListStudents = courseMapper.toDTO(courseRSM.getByName(courseName));
        if (courseListStudents == null) {
            throw new FunctionalException(ErrorsEnum.ERR_MCS_COURSE_NOT_FOUND.getErrorMessage());
        }
        return courseListStudents;
    }

}
