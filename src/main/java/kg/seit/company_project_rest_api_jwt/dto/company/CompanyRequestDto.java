package kg.seit.company_project_rest_api_jwt.dto.company;

import lombok.Getter;
import lombok.Setter;

/**
 * @author seiitbeknarynbaev
 */
@Getter
@Setter
public class CompanyRequestDto {
    private String companyName;
    private String locatedCountry;
}
