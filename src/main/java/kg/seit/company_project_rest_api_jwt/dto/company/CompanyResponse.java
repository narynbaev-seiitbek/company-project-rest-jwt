package kg.seit.company_project_rest_api_jwt.dto.company;

import kg.seit.company_project_rest_api_jwt.models.Course;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author seiitbeknarynbaev
 */
@Getter
@Setter
public class CompanyResponse {
    private Long id;
    private String companyName;
    private String locatedCountry;
    private List<Course> course;
}
