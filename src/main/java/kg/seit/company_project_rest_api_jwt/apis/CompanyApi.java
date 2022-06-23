package kg.seit.company_project_rest_api_jwt.apis;

import io.swagger.v3.oas.annotations.Operation;
import kg.seit.company_project_rest_api_jwt.dto.company.CompanyRequestDto;
import kg.seit.company_project_rest_api_jwt.dto.company.CompanyResponse;
import kg.seit.company_project_rest_api_jwt.dto.company.GetCompanyDto;
import kg.seit.company_project_rest_api_jwt.exceptions.SimpleResponse;
import kg.seit.company_project_rest_api_jwt.services.CompanyService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author seiitbeknarynbaev
 */
@RestController
@AllArgsConstructor
@RequestMapping("api/companies")
public class CompanyApi {

    private CompanyService companyService;

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/save")
    @Operation(summary = "Save method ", description = "Save company")
    public CompanyResponse save(@RequestBody CompanyRequestDto companyRequestDto) {
        return companyService.save(companyRequestDto);
    }

    @PreAuthorize("hasAnyAuthority('ADMIN','STUDENT')")
    @GetMapping
    @Operation(summary = "Find all method ", description = "find all companies")
    public List<CompanyResponse> findAll() {
        return companyService.findAll();
    }

    @PreAuthorize("hasAnyAuthority('ADMIN','STUDENT')")
    @GetMapping("find/by/{id}")
    @Operation(summary = "Find by id method ", description = "find by id company")
    public GetCompanyDto findBy(@PathVariable Long id) {
        return companyService.findBy(id);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PatchMapping("update/{id}")
    @Operation(summary = "Update method ", description = "Update company")
    public CompanyResponse update(@PathVariable Long id, @RequestBody CompanyRequestDto companyRequestDto) {
        return companyService.update(id, companyRequestDto);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Delete method ", description = "Delete company")
    public SimpleResponse deleteById(@PathVariable Long id) {
        return companyService.deleteById(id);
    }
}
