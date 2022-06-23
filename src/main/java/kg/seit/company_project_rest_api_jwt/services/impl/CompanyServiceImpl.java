package kg.seit.company_project_rest_api_jwt.services.impl;

import kg.seit.company_project_rest_api_jwt.dto.company.CompanyRequestDto;
import kg.seit.company_project_rest_api_jwt.dto.company.CompanyResponse;
import kg.seit.company_project_rest_api_jwt.dto.company.GetCompanyDto;
import kg.seit.company_project_rest_api_jwt.exceptions.BadRequestException;
import kg.seit.company_project_rest_api_jwt.exceptions.NotFoundException;
import kg.seit.company_project_rest_api_jwt.exceptions.SimpleResponse;
import kg.seit.company_project_rest_api_jwt.mapper.company.CompanyMapper;
import kg.seit.company_project_rest_api_jwt.mapper.company.GetCompanyMapper;
import kg.seit.company_project_rest_api_jwt.models.Company;
import kg.seit.company_project_rest_api_jwt.repo.CompanyRepository;
import kg.seit.company_project_rest_api_jwt.services.CompanyService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author seiitbeknarynbaev
 */
@Service
@AllArgsConstructor
@Slf4j
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;
    private final CompanyMapper companyMapper;
    private final GetCompanyMapper getCompanyMapper;

    @Override
    public CompanyResponse save(CompanyRequestDto companyRequestDto) {
        String companyName = companyRequestDto.getCompanyName();
        boolean exists = companyRepository.existsByCompanyName(companyName);
        if (exists) {
            throw new BadRequestException(
                    String.format("company with companyName = %s has already exists", companyName)
            );
        }
        Company company = companyMapper.convert(companyRequestDto);
        Company company1 = companyRepository.save(company);
        log.info("successful save company: {}", company1);
        return companyMapper.deConvert(company1);
    }

    @Override
    public List<CompanyResponse> findAll() {
        log.info("find all companies:{}", companyRepository.findAll());
        return companyRepository.findAll().stream()
                .map(companyMapper::deConvert).toList();
    }

    @Override
    public GetCompanyDto findBy(Long id) {
        if (id != null) {
            Company company = findById(id);
            log.info("successfully find by id company:{}", id);
            return getCompanyMapper.convert(company);
        }
        return null;
    }

    @Override
    @Transactional
    public CompanyResponse update(Long id, CompanyRequestDto companyRequestDto) {
        Company company = findById(id);
        String currentCompanyName = company.getCompanyName();
        String newCompanyName = companyRequestDto.getCompanyName();
        if (!currentCompanyName.equals(newCompanyName)) {
            company.setCompanyName(newCompanyName);
        }
        String currentLocatedCountry = company.getLocatedCountry();
        String newLocatedCountry = companyRequestDto.getLocatedCountry();
        if (!currentLocatedCountry.equals(newLocatedCountry)) {
            company.setLocatedCountry(newLocatedCountry);
        }
        log.info("successfully update company:{}", companyRequestDto);
        return companyMapper.deConvert(company);
    }

    @Override
    public SimpleResponse deleteById(Long id) {
        boolean exists = companyRepository.existsById(id);
        if (!exists) {
            throw new NotFoundException(
                    "Company with id = "+id+ " not found!");
        }
        log.info("successfully delete company id:{}", id);
        companyRepository.deleteById(id);
        return new SimpleResponse(
                "DELETED", "Successfully deleted"
        );
    }


    private Company findById(Long id) {
        return companyRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(
                        String.format("client with id = %s does not exists", id)
                ));
    }

}
