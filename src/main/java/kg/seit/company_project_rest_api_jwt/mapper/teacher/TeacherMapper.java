package kg.seit.company_project_rest_api_jwt.mapper.teacher;

import kg.seit.company_project_rest_api_jwt.dto.teacher.TeacherRequestDto;
import kg.seit.company_project_rest_api_jwt.dto.teacher.TeacherResponse;
import kg.seit.company_project_rest_api_jwt.enums.Role;
import kg.seit.company_project_rest_api_jwt.mapper.Convert;
import kg.seit.company_project_rest_api_jwt.models.Teacher;
import kg.seit.company_project_rest_api_jwt.models.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * @author seiitbeknarynbaev
 */
@Component
public class TeacherMapper implements Convert<Teacher, TeacherRequestDto, TeacherResponse> {

    private final PasswordEncoder passwordEncoder;

    public TeacherMapper(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Teacher convert(TeacherRequestDto teacherRequestDto) {
        Teacher teacher = new Teacher();
        teacher.setFirstName(teacherRequestDto.getFirstName());
        teacher.setLastName(teacherRequestDto.getLastName());
        teacher.setCourse(teacherRequestDto.getCourse());
        User user = new User();
        user.setEmail(teacherRequestDto.getEmail());
        user.setPassword(passwordEncoder.encode(teacherRequestDto.getPassword()));
        user.setRole(Role.TEACHER);
        teacher.setUser(user);
        return teacher;
    }

    @Override
    public TeacherResponse deConvert(Teacher teacher) {
        TeacherResponse teacherResponse = new TeacherResponse();
        teacherResponse.setId(teacher.getId());
        teacherResponse.setFirstName(teacher.getFirstName());
        teacherResponse.setLastName(teacher.getLastName());
        teacherResponse.setCourseId(teacher.getCourse().getId());
        return teacherResponse;
    }
}
