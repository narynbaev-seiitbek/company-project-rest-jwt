package kg.seit.company_project_rest_api_jwt.mapper.group;

import kg.seit.company_project_rest_api_jwt.dto.group.GetGroupDto;
import kg.seit.company_project_rest_api_jwt.models.Group;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * @author seiitbeknarynbaev
 */
@Component
public class GetGroupMapper implements Converter<Group, GetGroupDto> {
    @Override
    public GetGroupDto convert(Group group) {
        GetGroupDto getGroupDto=new GetGroupDto();
        getGroupDto.setGroupName(group.getGroupName());
        getGroupDto.setId(group.getId());
        getGroupDto.setDateOfStart(group.getDateOfStart());
        getGroupDto.setDateOfFinish(group.getDateOfFinish());
        return getGroupDto;
    }
}
