package com.poc.mapper;

import com.poc.common.mapper.DtoMapper;
import com.poc.model.domain.Course;
import com.poc.model.dto.CourseDTO;
import org.mapstruct.Mapper;

@Mapper
public interface CourseMapper extends DtoMapper<CourseDTO, Course> {

}
