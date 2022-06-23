package kg.seit.company_project_rest_api_jwt.repo;

import kg.seit.company_project_rest_api_jwt.models.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CompanyRepository extends JpaRepository<Company, Long> {

    @Query("select case when count(c) > 0 then true else false end" +
            " from Company c where c.companyName = ?1")
    boolean existsByCompanyName(String companyName);
}