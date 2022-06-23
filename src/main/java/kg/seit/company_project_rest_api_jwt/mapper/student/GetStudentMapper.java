package kg.seit.company_project_rest_api_jwt.mapper.student;

import kg.seit.company_project_rest_api_jwt.dto.student.GetStudentDto;
import kg.seit.company_project_rest_api_jwt.models.Student;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * @author seiitbeknarynbaev
 */
@Component
public class GetStudentMapper implements Converter<Student, GetStudentDto> {
    @Override
    public GetStudentDto convert(Student student) {
        GetStudentDto studentDto = new GetStudentDto();
        studentDto.setId(student.getId());
        studentDto.setFirstName(student.getFirstName());
        studentDto.setGroupId(student.getGroup().getId());
        studentDto.setStudyFormat(student.getStudyFormat());
        return studentDto;
    }
}
