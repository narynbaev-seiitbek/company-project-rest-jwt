package kg.seit.company_project_rest_api_jwt.services.impl;

import kg.seit.company_project_rest_api_jwt.dto.course.CourseRequestDto;
import kg.seit.company_project_rest_api_jwt.dto.course.CourseResponse;
import kg.seit.company_project_rest_api_jwt.dto.course.GetCourseDto;
import kg.seit.company_project_rest_api_jwt.exceptions.NotFoundException;
import kg.seit.company_project_rest_api_jwt.exceptions.SimpleResponse;
import kg.seit.company_project_rest_api_jwt.mapper.course.CourseMapper;
import kg.seit.company_project_rest_api_jwt.mapper.course.GetCourseMapper;
import kg.seit.company_project_rest_api_jwt.models.Course;
import kg.seit.company_project_rest_api_jwt.repo.CompanyRepository;
import kg.seit.company_project_rest_api_jwt.repo.CourseRepository;
import kg.seit.company_project_rest_api_jwt.services.CourseService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author seiitbeknarynbaev
 */
@Service
@AllArgsConstructor
@Slf4j
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;
    private final CompanyRepository companyRepository;
    private final CourseMapper courseMapper;
    private final GetCourseMapper getCourseMapper;

    @Override
    public CourseResponse save(CourseRequestDto courseRequestDto) {
        courseRequestDto.setCompany(companyRepository.getById(courseRequestDto.getCompanyId()));
        Course course = courseMapper.convert(courseRequestDto);
        Course course1 = courseRepository.save(course);
        log.info("successful save course:{}", course);
        return courseMapper.deConvert(course1);

    }

    @Override
    public List<CourseResponse> findAll() {
        return courseRepository.findAll().stream()
                .map(courseMapper::deConvert).toList();
    }

    @Override
    public GetCourseDto findBy(Long id) {
        if (id != null) {
            Course course = findById(id);
            log.info("successful find by id:{}", id);
            return getCourseMapper.convert(course);
        } else {
            throw new NotFoundException(
                    String.format("not found=%s id", id)
            );
        }
    }

    private Course findById(Long id) {
        return courseRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(
                        String.format("course with id = %s does not exists", id)
                ));
    }


    @Override
    @Transactional
    public CourseResponse update(Long id, CourseRequestDto courseRequestDto) {
        Course course = findById(id);
        String currentCourseName = course.getCourseName();
        String newCourseName = courseRequestDto.getCourseName();
        if (!currentCourseName.equals(newCourseName)) {
            course.setCourseName(newCourseName);
        }
        String currenDuration = course.getDuration();
        String newDuration = courseRequestDto.getDuration();
        if (!currenDuration.equals(newDuration)) {
            course.setDuration(newDuration);
        }
        log.info("successful update course id:{}", id);
        return courseMapper.deConvert(course);
    }

    @Override
    public SimpleResponse deleteById(Long id) {
        boolean exists = courseRepository.existsById(id);
        if (!exists) {
            throw new NotFoundException(
                    "Course with id = "+id+ " not found!");
        }
        log.info("successful delete by id course:{}", id);
        courseRepository.deleteById(id);
        return new SimpleResponse(
                "DELETED", "Successfully deleted"
        );

    }

}

