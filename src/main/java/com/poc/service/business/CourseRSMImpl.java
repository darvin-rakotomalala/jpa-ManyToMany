package com.poc.service.business;

import com.poc.exception.ErrorsEnum;
import com.poc.exception.FunctionalException;
import com.poc.model.domain.Course;
import com.poc.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class CourseRSMImpl implements CourseRSM {

    private final CourseRepository courseRepository;

    @Override
    public Course getByName(String courseName) {
        try {
            log.info("----- getByName : {}", courseName);
            if (StringUtils.isBlank(courseName)) {
                throw new FunctionalException(ErrorsEnum.ERR_MCS_COURSE_NAME_EMPTY.getErrorMessage());
            }
            return courseRepository.findByName(courseName);
        } catch (Exception e) {
            log.error("Error getByName : {} {}", e.getMessage(), e);
            e.printStackTrace();
            throw e;
        }
    }
}
