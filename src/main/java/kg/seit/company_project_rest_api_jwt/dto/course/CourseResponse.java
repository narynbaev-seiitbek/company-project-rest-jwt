package kg.seit.company_project_rest_api_jwt.dto.course;

import kg.seit.company_project_rest_api_jwt.models.Group;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author seiitbeknarynbaev
 */
@Getter
@Setter
public class CourseResponse {
    private Long id;
    private String courseName;
    private String duration;
    private List<Group> group;
}
