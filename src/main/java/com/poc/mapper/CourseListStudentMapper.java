package com.poc.mapper;

import com.poc.common.mapper.DtoMapper;
import com.poc.model.domain.Course;
import com.poc.model.dto.CourseListStudentDTO;
import org.mapstruct.Mapper;

@Mapper
public interface CourseListStudentMapper extends DtoMapper<CourseListStudentDTO, Course> {

}
