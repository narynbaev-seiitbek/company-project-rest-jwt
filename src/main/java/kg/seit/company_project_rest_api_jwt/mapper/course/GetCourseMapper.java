package kg.seit.company_project_rest_api_jwt.mapper.course;

import kg.seit.company_project_rest_api_jwt.dto.course.GetCourseDto;
import kg.seit.company_project_rest_api_jwt.models.Course;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * @author seiitbeknarynbaev
 */
@Component
public class GetCourseMapper  implements Converter<Course, GetCourseDto> {
    @Override
    public GetCourseDto convert(Course course) {
        GetCourseDto getCourseDto=new GetCourseDto();
        getCourseDto.setCourseName(course.getCourseName());
        getCourseDto.setId(course.getId());
        getCourseDto.setDuration(course.getDuration());
        getCourseDto.setCompanyId(course.getCompany().getId());
        return getCourseDto;
    }
}
