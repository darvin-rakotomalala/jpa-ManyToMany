package com.poc.constraint.validation;

import com.poc.exception.ErrorsEnum;
import com.poc.model.dto.StudentDTO;
import com.poc.model.requests.StudentRequestDTO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class StudentValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return StudentRequestDTO.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        StudentRequestDTO student = (StudentRequestDTO) target;
        if (StringUtils.isEmpty(student.getName())) {
            errors.rejectValue("name", "name.value.empty", ErrorsEnum.ERR_MCS_STUDENT_NAME_EMPTY.getErrorMessage());
        }
    }

}
