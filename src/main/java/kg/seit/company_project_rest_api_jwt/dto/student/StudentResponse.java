package kg.seit.company_project_rest_api_jwt.dto.student;

import kg.seit.company_project_rest_api_jwt.enums.StudyFormat;
import lombok.Getter;
import lombok.Setter;

/**
 * @author seiitbeknarynbaev
 */
@Getter
@Setter
public class StudentResponse {
    private Long id;
    private String firstName;
    private String email;
    private Long groupId;
    private StudyFormat studyFormat;
}