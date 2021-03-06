package kg.seit.company_project_rest_api_jwt.dto.teacher;

import com.fasterxml.jackson.annotation.JsonIgnore;
import kg.seit.company_project_rest_api_jwt.models.Course;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

/**
 * @author seiitbeknarynbaev
 */
@Getter
@Setter
public class TeacherRequestDto {
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @Email
    private String email;
    private String password;
    @JsonIgnore
    private Course course;
    private Long courseId;
}
