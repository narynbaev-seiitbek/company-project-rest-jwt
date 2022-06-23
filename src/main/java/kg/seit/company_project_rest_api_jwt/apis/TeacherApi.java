package kg.seit.company_project_rest_api_jwt.apis;

import io.swagger.v3.oas.annotations.Operation;
import kg.seit.company_project_rest_api_jwt.dto.teacher.GetTeacherDto;
import kg.seit.company_project_rest_api_jwt.dto.teacher.TeacherRequestDto;
import kg.seit.company_project_rest_api_jwt.dto.teacher.TeacherResponse;
import kg.seit.company_project_rest_api_jwt.exceptions.SimpleResponse;
import kg.seit.company_project_rest_api_jwt.services.TeacherService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author seiitbeknarynbaev
 */
@RestController
@RequestMapping("api/teacher")
@AllArgsConstructor
public class TeacherApi {
    private final TeacherService teacherService;

    @PreAuthorize("hasAuthority('ADMIN')")
    @Operation(summary = "save method ", description = "save teacher")
    @PostMapping("/save")
    public TeacherResponse saveTeacher(@RequestBody TeacherRequestDto teacherRequestDto) {
        return teacherService.save(teacherRequestDto);
    }

    @PreAuthorize("hasAnyAuthority('ADMIN','STUDENT')")
    @Operation(summary = "find all method ", description = "find all teacher")
    @GetMapping
    public List<TeacherResponse> findAll() {
        return teacherService.findAll();
    }

    @PreAuthorize("hasAnyAuthority('ADMIN','STUDENT')")
    @Operation(summary = "find by id method ", description = "find by id teacher")
    @GetMapping("/find/{id}")
    public GetTeacherDto getById(@PathVariable Long id) {
        return teacherService.findBy(id);
    }

    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @Operation(summary = "update method  ", description = "update teacher")
    @PatchMapping("/update/{id}")
    public TeacherResponse updateTeacher(@PathVariable Long id, @RequestBody TeacherRequestDto teacherRequestDto) {
        return teacherService.update(id, teacherRequestDto);
    }

    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @Operation(summary = "delete method ", description = "delete teacher")
    @DeleteMapping("/delete/{id}")
    public SimpleResponse deleteById(@PathVariable Long id) {
        return teacherService.deleteById(id);
    }

}

