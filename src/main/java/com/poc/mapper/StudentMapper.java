package com.poc.mapper;

import com.poc.common.mapper.DtoMapper;
import com.poc.model.domain.Student;
import com.poc.model.dto.StudentDTO;
import org.mapstruct.Mapper;

@Mapper
public interface StudentMapper extends DtoMapper<StudentDTO, Student> {

}
