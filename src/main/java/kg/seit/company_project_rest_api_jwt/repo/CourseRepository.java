package kg.seit.company_project_rest_api_jwt.repo;

import kg.seit.company_project_rest_api_jwt.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}