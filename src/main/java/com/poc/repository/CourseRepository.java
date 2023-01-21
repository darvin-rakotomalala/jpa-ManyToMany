package com.poc.repository;

import com.poc.model.domain.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
    public Course findByName(String courseName);
}
