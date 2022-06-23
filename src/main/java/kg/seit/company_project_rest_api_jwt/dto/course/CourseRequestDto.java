package kg.seit.company_project_rest_api_jwt.dto.course;

import com.fasterxml.jackson.annotation.JsonIgnore;
import kg.seit.company_project_rest_api_jwt.models.Company;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author seiitbeknarynbaev
 */
@Getter
@Setter
public class CourseRequestDto {
    @NotBlank
    private String courseName;
    @NotNull
    private String duration;
    @JsonIgnore
    private Company company;
    private Long companyId;
}
