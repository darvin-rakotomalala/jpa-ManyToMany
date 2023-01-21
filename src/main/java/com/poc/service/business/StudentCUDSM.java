package com.poc.service.business;

import com.poc.model.domain.Student;

public interface StudentCUDSM {
    public Student addStudent(Student student);
    public Student updateStudent(Student student);
    public void deleteStudent(Long id);
}
