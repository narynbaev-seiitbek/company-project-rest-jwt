package kg.seit.company_project_rest_api_jwt.services;

import kg.seit.company_project_rest_api_jwt.dto.course.CourseRequestDto;
import kg.seit.company_project_rest_api_jwt.dto.course.CourseResponse;
import kg.seit.company_project_rest_api_jwt.dto.course.GetCourseDto;
import kg.seit.company_project_rest_api_jwt.exceptions.SimpleResponse;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author seiitbeknarynbaev
 */
@Service
public interface CourseService {
    CourseResponse save(CourseRequestDto courseRequestDto);

    List<CourseResponse> findAll();

    GetCourseDto findBy(Long id);

    CourseResponse update(Long id, CourseRequestDto courseRequestDto);

    SimpleResponse deleteById(Long id);

}
