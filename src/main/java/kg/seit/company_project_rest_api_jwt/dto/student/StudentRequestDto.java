package kg.seit.company_project_rest_api_jwt.dto.student;

import com.fasterxml.jackson.annotation.JsonIgnore;
import kg.seit.company_project_rest_api_jwt.enums.StudyFormat;
import kg.seit.company_project_rest_api_jwt.models.Group;
import lombok.Getter;
import lombok.Setter;

/**
 * @author seiitbeknarynbaev
 */
@Getter
@Setter
public class StudentRequestDto {
    private String firstName;
    private String email;
    @JsonIgnore
    private Group group;
    private String password;
    private Long groupId;
    private StudyFormat studyFormat;
}
