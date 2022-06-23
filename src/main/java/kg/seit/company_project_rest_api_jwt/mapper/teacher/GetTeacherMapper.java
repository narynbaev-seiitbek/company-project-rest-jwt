package kg.seit.company_project_rest_api_jwt.mapper.teacher;

import kg.seit.company_project_rest_api_jwt.dto.teacher.GetTeacherDto;
import kg.seit.company_project_rest_api_jwt.models.Teacher;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * @author seiitbeknarynbaev
 */
@Component
public class GetTeacherMapper implements Converter<Teacher, GetTeacherDto> {
    @Override
    public GetTeacherDto convert(Teacher teacher) {
        GetTeacherDto getTeacherDto=new GetTeacherDto();
        getTeacherDto.setId(teacher.getId());
        getTeacherDto.setFirstName(teacher.getFirstName());
        getTeacherDto.setLastName(teacher.getLastName());
        getTeacherDto.setCourseId(teacher.getCourse().getId());
        return getTeacherDto;
    }
}
