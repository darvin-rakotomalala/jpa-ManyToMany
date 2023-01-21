package com.poc.service.application;

import com.poc.model.dto.CourseListStudentDTO;

public interface CourseRSA {
    public CourseListStudentDTO getByName(String courseName);
}
