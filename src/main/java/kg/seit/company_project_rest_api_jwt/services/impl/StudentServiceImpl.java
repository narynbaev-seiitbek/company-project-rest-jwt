package kg.seit.company_project_rest_api_jwt.services.impl;

import kg.seit.company_project_rest_api_jwt.dto.student.GetStudentDto;
import kg.seit.company_project_rest_api_jwt.dto.student.StudentRequestDto;
import kg.seit.company_project_rest_api_jwt.dto.student.StudentResponse;
import kg.seit.company_project_rest_api_jwt.enums.StudyFormat;
import kg.seit.company_project_rest_api_jwt.exceptions.BadRequestException;
import kg.seit.company_project_rest_api_jwt.exceptions.NotFoundException;
import kg.seit.company_project_rest_api_jwt.exceptions.SimpleResponse;
import kg.seit.company_project_rest_api_jwt.mapper.student.GetStudentMapper;
import kg.seit.company_project_rest_api_jwt.mapper.student.StudentMapper;
import kg.seit.company_project_rest_api_jwt.models.Student;
import kg.seit.company_project_rest_api_jwt.repo.GroupRepository;
import kg.seit.company_project_rest_api_jwt.repo.StudentRepository;
import kg.seit.company_project_rest_api_jwt.services.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author seiitbeknarynbaev
 */
@AllArgsConstructor
@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;
    private final GetStudentMapper getStudentMapper;
    private final GroupRepository groupRepository;

    @Override
    public StudentResponse save(StudentRequestDto studentRequestDto) {
        String email = studentRequestDto.getEmail();
        boolean exists = studentRepository.existsByFirstName(email);
        if (exists) {
            throw new BadRequestException(
                    String.format("student with email = %s has already exists", email)
            );
        }
        studentRequestDto.setGroup(groupRepository.getById(studentRequestDto.getGroupId()));
        Student student = studentMapper.convert(studentRequestDto);
        Student student1 = studentRepository.save(student);

        return studentMapper.deConvert(student1);
    }

    @Override
    public List<StudentResponse> findAll() {
        return studentRepository.findAll().stream()
                .map(studentMapper::deConvert).toList();
    }

    @Override
    public GetStudentDto findBy(Long id) {
        if (id != null) {
            Student student = findById(id);
            return getStudentMapper.convert(student);
        } else {
            throw new NotFoundException(
                    String.format("not found=%s id", id)
            );
        }
    }

    private Student findById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(
                        String.format("student with id = %s does not exists", id)
                ));
    }

    @Override
    @Transactional
    public StudentResponse update(Long id, StudentRequestDto studentRequestDto) {
        Student student = findById(id);
        String currents = student.getFirstName();
        String newFirstName = studentRequestDto.getFirstName();
        if (!currents.equals(newFirstName)) {
            student.setFirstName(newFirstName);
        }
        String currentEmail = student.getUser().getEmail();
        String newEmail = studentRequestDto.getEmail();
        if (!currentEmail.equals(newEmail)) {
            student.getUser().setEmail(newEmail);
        }
        StudyFormat concurrent = student.getStudyFormat();
        StudyFormat format = studentRequestDto.getStudyFormat();
        if (!concurrent.equals(format)) {
            student.setStudyFormat(format);
        }

        return studentMapper.deConvert(student);
    }

    @Override
    public SimpleResponse deleteById(Long id) {
        boolean exists = studentRepository.existsById(id);
        if (!exists) {
            throw new NotFoundException(
                    "Student with id = "+id+ " not found!");
        }
        studentRepository.deleteById(id);
        return new SimpleResponse(
                "DELETED", "Successfully deleted"
        );
    }

}
