package kg.seit.company_project_rest_api_jwt.apis;

import io.swagger.v3.oas.annotations.Operation;
import kg.seit.company_project_rest_api_jwt.dto.student.GetStudentDto;
import kg.seit.company_project_rest_api_jwt.dto.student.StudentRequestDto;
import kg.seit.company_project_rest_api_jwt.dto.student.StudentResponse;
import kg.seit.company_project_rest_api_jwt.exceptions.SimpleResponse;
import kg.seit.company_project_rest_api_jwt.services.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author seiitbeknarynbaev
 */
@RestController
@AllArgsConstructor
@RequestMapping("/api/student")
public class StudentApi {
    private final StudentService studentService;

    @PreAuthorize("hasAnyAuthority('ADMIN','STUDENT')")
    @PostMapping("/save")
    @Operation(summary = "save method ", description = "save student")
    public StudentResponse saveStudent(@RequestBody StudentRequestDto studentRequestDto) {
        return studentService.save(studentRequestDto);
    }

    @PreAuthorize("hasAnyAuthority('ADMIN','STUDENT')")
    @GetMapping()
    @Operation(summary = "find all method ", description = "find all student")
    public List<StudentResponse> findAll() {
        return studentService.findAll();
    }

    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @PatchMapping("update/{id}")
    @Operation(summary = "update method ", description = "update student")
    public StudentResponse updateStudent(@PathVariable Long id, @RequestBody StudentRequestDto studentRequestDto) {
        return studentService.update(id, studentRequestDto);
    }

    @PreAuthorize("hasAnyAuthority('ADMIN','STUDENT')")
    @GetMapping("find/{id}")
    @Operation(summary = "find by id method ", description = "find by id student")
    public GetStudentDto getById(@PathVariable Long id) {
        return studentService.findBy(id);
    }

    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @Operation(summary = "delete method ", description = "delete student")
    @DeleteMapping("delete/{id}")
    public SimpleResponse deleteById(@PathVariable Long id) {
        return studentService.deleteById(id);
    }
}

