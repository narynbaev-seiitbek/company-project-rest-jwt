package kg.seit.company_project_rest_api_jwt.dto.teacher;

import lombok.Getter;
import lombok.Setter;

/**
 * @author seiitbeknarynbaev
 */
@Getter
@Setter
public class GetTeacherDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private Long courseId;
}
