package kg.seit.company_project_rest_api_jwt.dto.group;

import com.fasterxml.jackson.annotation.JsonIgnore;
import kg.seit.company_project_rest_api_jwt.models.Course;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

/**
 * @author seiitbeknarynbaev
 */
@Getter
@Setter
public class GroupRequestDto {
    private String groupName;
    private LocalDate dateOfStart;
    private LocalDate dateOfFinish;
    @JsonIgnore
    private Course course;
    private Long courseId;
}
