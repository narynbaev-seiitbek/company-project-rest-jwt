package kg.seit.company_project_rest_api_jwt.services;

import kg.seit.company_project_rest_api_jwt.dto.teacher.GetTeacherDto;
import kg.seit.company_project_rest_api_jwt.dto.teacher.TeacherRequestDto;
import kg.seit.company_project_rest_api_jwt.dto.teacher.TeacherResponse;
import kg.seit.company_project_rest_api_jwt.exceptions.SimpleResponse;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author seiitbeknarynbaev
 */
@Service
public interface TeacherService {
    TeacherResponse save(TeacherRequestDto teacherRequestDto);

    List<TeacherResponse> findAll();

    GetTeacherDto findBy(Long id);

    TeacherResponse update(Long id, TeacherRequestDto teacherRequestDto);

    SimpleResponse deleteById(Long id);

    TeacherResponse getById(Long id);
}

