package kg.seit.company_project_rest_api_jwt.apis;

import io.swagger.v3.oas.annotations.Operation;
import kg.seit.company_project_rest_api_jwt.dto.course.CourseRequestDto;
import kg.seit.company_project_rest_api_jwt.dto.course.CourseResponse;
import kg.seit.company_project_rest_api_jwt.dto.course.GetCourseDto;
import kg.seit.company_project_rest_api_jwt.exceptions.SimpleResponse;
import kg.seit.company_project_rest_api_jwt.services.CourseService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author seiitbeknarynbaev
 */
@RestController
@AllArgsConstructor
@RequestMapping("api/courses")
public class CourseApi {
    private final CourseService courseService;

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/save")
    @Operation(summary = "save method ", description = "save course")
    public CourseResponse saveCourse(@RequestBody CourseRequestDto courseRequestDto) {
        return courseService.save(courseRequestDto);
    }

    @PreAuthorize("hasAnyAuthority('ADMIN','STUDENT')")
    @GetMapping
    @Operation(summary = "find all method ", description = "find all courses")

    public List<CourseResponse> findAllCourse() {
        return courseService.findAll();
    }

    @PreAuthorize("hasAnyAuthority('ADMIN','STUDENT')")
    @GetMapping("find/{id}")
    @Operation(summary = "find by id method ", description = "find by id course")

    public GetCourseDto findByIdCourse(@PathVariable Long id) {
        return courseService.findBy(id);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PatchMapping("update/{id}")
    @Operation(summary = "update method", description = " update course")

    public CourseResponse update(@PathVariable Long id, @RequestBody CourseRequestDto courseRequestDto) {
        return courseService.update(id, courseRequestDto);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping("delete/{id}")
    @Operation(summary = "delete method", description = " delete course")
    public SimpleResponse deleteByIdCourse(@PathVariable Long id) {
        return courseService.deleteById(id);
    }
}
