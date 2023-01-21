package com.poc.service.business;

import com.poc.model.domain.Course;

public interface CourseRSM {
    public Course getByName(String courseName);
}
