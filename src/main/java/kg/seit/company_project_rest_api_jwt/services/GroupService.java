package kg.seit.company_project_rest_api_jwt.services;

import kg.seit.company_project_rest_api_jwt.dto.group.GetGroupDto;
import kg.seit.company_project_rest_api_jwt.dto.group.GroupRequestDto;
import kg.seit.company_project_rest_api_jwt.dto.group.GroupResponse;
import kg.seit.company_project_rest_api_jwt.exceptions.SimpleResponse;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author seiitbeknarynbaev
 */
@Service
public interface GroupService {
    GroupResponse save(GroupRequestDto groupRequestDto);

    List<GroupResponse> findAll();

    GetGroupDto findBy(Long id);

    GroupResponse update(Long id, GroupRequestDto groupRequestDto);

    SimpleResponse deleteById(Long id);

    GroupResponse getById(Long id);
}
