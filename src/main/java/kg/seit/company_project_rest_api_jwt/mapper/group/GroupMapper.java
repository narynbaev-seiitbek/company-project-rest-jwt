package kg.seit.company_project_rest_api_jwt.mapper.group;

import kg.seit.company_project_rest_api_jwt.dto.group.GroupRequestDto;
import kg.seit.company_project_rest_api_jwt.dto.group.GroupResponse;
import kg.seit.company_project_rest_api_jwt.mapper.Convert;
import kg.seit.company_project_rest_api_jwt.models.Group;
import org.springframework.stereotype.Component;

/**
 * @author seiitbeknarynbaev
 */
@Component
public class GroupMapper implements Convert<Group, GroupRequestDto, GroupResponse> {
    @Override
    public Group convert(GroupRequestDto groupRequestDto) {
        Group group = new Group();
        group.setGroupName(groupRequestDto.getGroupName());
        group.setCourse(groupRequestDto.getCourse());
        group.setDateOfStart(groupRequestDto.getDateOfStart());
        group.setDateOfFinish(groupRequestDto.getDateOfFinish());
        return group;
    }

    @Override
    public GroupResponse deConvert(Group group) {
        GroupResponse groupResponse = new GroupResponse();
        groupResponse.setGroupName(group.getGroupName());
        groupResponse.setId(group.getId());
        groupResponse.setDateOfStart(group.getDateOfStart());
        groupResponse.setDateOfFinish(group.getDateOfFinish());
        groupResponse.setStudent(group.getStudents());
        return groupResponse;
    }
}
