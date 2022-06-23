package kg.seit.company_project_rest_api_jwt.mapper.course;

import kg.seit.company_project_rest_api_jwt.dto.course.CourseRequestDto;
import kg.seit.company_project_rest_api_jwt.dto.course.CourseResponse;
import kg.seit.company_project_rest_api_jwt.mapper.Convert;
import kg.seit.company_project_rest_api_jwt.models.Course;
import org.springframework.stereotype.Component;

/**
 * @author seiitbeknarynbaev
 */
@Component
public class CourseMapper implements Convert<Course, CourseRequestDto, CourseResponse> {

    @Override
    public Course convert(CourseRequestDto courseRequestDto) {
        Course course=new Course();
        course.setCourseName(courseRequestDto.getCourseName());
        course.setDuration(courseRequestDto.getDuration());
        course.setCompany(courseRequestDto.getCompany());
        return course;
    }

    @Override
    public CourseResponse deConvert(Course course) {
        CourseResponse courseResponse=new CourseResponse();
        courseResponse.setId(course.getId());
        courseResponse.setCourseName(course.getCourseName());
        courseResponse.setDuration(course.getDuration());

        courseResponse.setGroup(course.getGroups());
        return courseResponse;
    }
}
