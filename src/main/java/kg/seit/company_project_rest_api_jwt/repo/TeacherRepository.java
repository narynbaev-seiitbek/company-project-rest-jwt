package kg.seit.company_project_rest_api_jwt.repo;

import kg.seit.company_project_rest_api_jwt.models.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {

}