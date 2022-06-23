package kg.seit.company_project_rest_api_jwt.repo;

import kg.seit.company_project_rest_api_jwt.models.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface GroupRepository extends JpaRepository<Group, Long> {

    @Override
    @Modifying
    @Query("delete from Group g where g.id=:id and g.id=:id ")
    void deleteById(Long id);
}