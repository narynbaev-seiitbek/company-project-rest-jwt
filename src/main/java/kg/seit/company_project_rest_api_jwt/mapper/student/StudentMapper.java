package kg.seit.company_project_rest_api_jwt.mapper.student;

import kg.seit.company_project_rest_api_jwt.dto.student.StudentRequestDto;
import kg.seit.company_project_rest_api_jwt.dto.student.StudentResponse;
import kg.seit.company_project_rest_api_jwt.enums.Role;
import kg.seit.company_project_rest_api_jwt.mapper.Convert;
import kg.seit.company_project_rest_api_jwt.models.Student;
import kg.seit.company_project_rest_api_jwt.models.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * @author seiitbeknarynbaev
 */
@Component
public class StudentMapper implements Convert<Student, StudentRequestDto, StudentResponse> {
    private final PasswordEncoder passwordEncoder;

    public StudentMapper(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Student convert(StudentRequestDto studentRequestDto) {
        Student student = new Student();
        student.setFirstName(studentRequestDto.getFirstName());
        student.setStudyFormat(studentRequestDto.getStudyFormat());
        student.setGroup(studentRequestDto.getGroup());
        User user=new User();
        user.setEmail(studentRequestDto.getEmail());
        user.setPassword(passwordEncoder.encode(studentRequestDto.getPassword()));
        user.setRole(Role.STUDENT);
        student.setUser(user);
        return student;
    }

    @Override
    public StudentResponse deConvert(Student student) {
        StudentResponse studentResponse = new StudentResponse();
        studentResponse.setFirstName(student.getFirstName());
        studentResponse.setId(student.getId());
        studentResponse.setStudyFormat(student.getStudyFormat());
        studentResponse.setGroupId(student.getGroup().getId());
        return studentResponse;
    }
}
