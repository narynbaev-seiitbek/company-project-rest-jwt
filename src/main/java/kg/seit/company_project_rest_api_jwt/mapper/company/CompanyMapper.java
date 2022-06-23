package kg.seit.company_project_rest_api_jwt.mapper.company;

import kg.seit.company_project_rest_api_jwt.dto.company.CompanyRequestDto;
import kg.seit.company_project_rest_api_jwt.dto.company.CompanyResponse;
import kg.seit.company_project_rest_api_jwt.mapper.Convert;
import kg.seit.company_project_rest_api_jwt.models.Company;
import org.springframework.stereotype.Component;

/**
 * @author seiitbeknarynbaev
 */
@Component
public class CompanyMapper implements Convert<Company, CompanyRequestDto, CompanyResponse> {

    @Override
    public Company convert(CompanyRequestDto companyRequestDto) {
        Company company = new Company();
        company.setCompanyName(companyRequestDto.getCompanyName());
        company.setLocatedCountry(companyRequestDto.getLocatedCountry());
        return company;
    }

    @Override
    public CompanyResponse deConvert(Company company) {
        CompanyResponse companyResponse=new CompanyResponse();
        companyResponse.setId(company.getId());
        companyResponse.setCompanyName(company.getCompanyName());
        companyResponse.setLocatedCountry(company.getLocatedCountry());
        companyResponse.setCourse(company.getCourses());
        return companyResponse;
    }


}
