package kg.seit.company_project_rest_api_jwt.services;

import kg.seit.company_project_rest_api_jwt.dto.company.CompanyRequestDto;
import kg.seit.company_project_rest_api_jwt.dto.company.CompanyResponse;
import kg.seit.company_project_rest_api_jwt.dto.company.GetCompanyDto;
import kg.seit.company_project_rest_api_jwt.exceptions.SimpleResponse;

import java.util.List;

/**
 * @author seiitbeknarynbaev
 */
public interface CompanyService {
    CompanyResponse save(CompanyRequestDto companyRequestDto);

    List<CompanyResponse> findAll();

    GetCompanyDto findBy(Long id);

    CompanyResponse update(Long id, CompanyRequestDto companyRequestDto);

    SimpleResponse deleteById(Long id);
}
