package kg.seit.company_project_rest_api_jwt.mapper.company;

import kg.seit.company_project_rest_api_jwt.dto.company.GetCompanyDto;
import kg.seit.company_project_rest_api_jwt.models.Company;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * @author seiitbeknarynbaev
 */
@Component
public class GetCompanyMapper implements Converter<Company, GetCompanyDto> {

    @Override
    public GetCompanyDto convert(Company company) {
        GetCompanyDto getCompanyDto=new GetCompanyDto();
        getCompanyDto.setCompanyName(company.getCompanyName());
        getCompanyDto.setId(company.getId());
        getCompanyDto.setLocatedCountry(company.getLocatedCountry());
        getCompanyDto.setCourseSet(company.getCourses());
        return getCompanyDto;
    }
}