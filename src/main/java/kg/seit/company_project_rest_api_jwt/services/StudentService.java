package kg.seit.company_project_rest_api_jwt.services;

import kg.seit.company_project_rest_api_jwt.dto.student.GetStudentDto;
import kg.seit.company_project_rest_api_jwt.dto.student.StudentRequestDto;
import kg.seit.company_project_rest_api_jwt.dto.student.StudentResponse;
import kg.seit.company_project_rest_api_jwt.exceptions.SimpleResponse;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author seiitbeknarynbaev
 */
@Service
public interface StudentService {
    StudentResponse save(StudentRequestDto studentRequestDto);

    List<StudentResponse> findAll();

    GetStudentDto findBy(Long id);

    StudentResponse update(Long id, StudentRequestDto studentRequestDto);

    SimpleResponse deleteById(Long id);


}
