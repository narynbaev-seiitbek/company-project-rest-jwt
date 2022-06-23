package kg.seit.company_project_rest_api_jwt.dto.group;

import kg.seit.company_project_rest_api_jwt.models.Student;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

/**
 * @author seiitbeknarynbaev
 */
@Getter
@Setter
public class GroupResponse {
    private Long id;
    private String groupName;
    private LocalDate dateOfStart;
    private LocalDate dateOfFinish;

    private List<Student> student;

}
