package kg.seit.company_project_rest_api_jwt.dto.course;

import lombok.Getter;
import lombok.Setter;

/**
 * @author seiitbeknarynbaev
 */
@Getter
@Setter
public class GetCourseDto {
    private Long id;
    private String courseName;
    private String duration;
    private Long companyId;
}
