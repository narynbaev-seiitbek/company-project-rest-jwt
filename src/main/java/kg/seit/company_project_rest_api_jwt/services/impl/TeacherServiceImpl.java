package kg.seit.company_project_rest_api_jwt.services.impl;

import kg.seit.company_project_rest_api_jwt.dto.teacher.GetTeacherDto;
import kg.seit.company_project_rest_api_jwt.dto.teacher.TeacherRequestDto;
import kg.seit.company_project_rest_api_jwt.dto.teacher.TeacherResponse;
import kg.seit.company_project_rest_api_jwt.exceptions.NotFoundException;
import kg.seit.company_project_rest_api_jwt.exceptions.SimpleResponse;
import kg.seit.company_project_rest_api_jwt.mapper.teacher.GetTeacherMapper;
import kg.seit.company_project_rest_api_jwt.mapper.teacher.TeacherMapper;
import kg.seit.company_project_rest_api_jwt.models.Teacher;
import kg.seit.company_project_rest_api_jwt.repo.CourseRepository;
import kg.seit.company_project_rest_api_jwt.repo.TeacherRepository;
import kg.seit.company_project_rest_api_jwt.services.TeacherService;
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
public class TeacherServiceImpl implements TeacherService {
    private final TeacherRepository teacherRepository;
    private final TeacherMapper teacherMapper;
    private final GetTeacherMapper getTeacherMapper;
    private final CourseRepository courseRepository;

    @Override
    public TeacherResponse save(TeacherRequestDto teacherRequestDto) {
        teacherRequestDto.setCourse(courseRepository.getById(teacherRequestDto.getCourseId()));
        Teacher teacher = teacherMapper.convert(teacherRequestDto);
        Teacher teacher1 = teacherRepository.save(teacher);
        log.info("successful save teacher: {}", teacher1);
        return teacherMapper.deConvert(teacher1);
    }

    @Override
    public List<TeacherResponse> findAll() {
        return teacherRepository.findAll().stream()
                .map(teacherMapper::deConvert).toList();
    }

    @Override
    public GetTeacherDto findBy(Long id) {
        if (id != null) {
            Teacher teacher = findById(id);
            return getTeacherMapper.convert(teacher);
        } else {
            throw new NotFoundException(
                    String.format("not found=%s id", id)
            );
        }
    }

    private Teacher findById(Long id) {
        return teacherRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(
                        String.format("teacher with id = %s does not exists", id)
                ));
    }
    @Override
    @Transactional
    public TeacherResponse update(Long id, TeacherRequestDto teacherRequestDto) {
        Teacher teacher = findById(id);
        String currentFirstName = teacher.getFirstName();
        String newFirstName = teacherRequestDto.getFirstName();
        if (!currentFirstName.equals(newFirstName)) {
            teacher.setFirstName(newFirstName);
        }
        String currentLastName = teacher.getLastName();
        String newLastName = teacherRequestDto.getLastName();
        if (!currentLastName.equals(newLastName)) {
            teacher.setLastName(newLastName);
        }
        return teacherMapper.deConvert(teacher);
    }
    @Override
    public SimpleResponse deleteById(Long id) {
        boolean exists = teacherRepository.existsById(id);
        if (!exists) {
            throw new NotFoundException(
                    "Teacher with id = "+id+ " not found!");
        }
        teacherRepository.deleteById(id);
        return new SimpleResponse(
                "DELETED", "Successfully deleted"
        );
    }

    @Override
    public TeacherResponse getById(Long id) {
        return teacherMapper.deConvert(teacherRepository.getById(id));

    }
}

