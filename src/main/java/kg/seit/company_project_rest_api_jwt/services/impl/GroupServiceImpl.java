package kg.seit.company_project_rest_api_jwt.services.impl;

import kg.seit.company_project_rest_api_jwt.dto.group.GetGroupDto;
import kg.seit.company_project_rest_api_jwt.dto.group.GroupRequestDto;
import kg.seit.company_project_rest_api_jwt.dto.group.GroupResponse;
import kg.seit.company_project_rest_api_jwt.exceptions.NotFoundException;
import kg.seit.company_project_rest_api_jwt.exceptions.SimpleResponse;
import kg.seit.company_project_rest_api_jwt.mapper.group.GetGroupMapper;
import kg.seit.company_project_rest_api_jwt.mapper.group.GroupMapper;
import kg.seit.company_project_rest_api_jwt.models.Group;
import kg.seit.company_project_rest_api_jwt.repo.CourseRepository;
import kg.seit.company_project_rest_api_jwt.repo.GroupRepository;
import kg.seit.company_project_rest_api_jwt.services.GroupService;
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
public class GroupServiceImpl implements GroupService {
    private final GroupRepository groupRepository;
    private final GroupMapper groupMapper;
    private final GetGroupMapper getGroupMapper;
    private final CourseRepository courseRepository;

    @Override
    public GroupResponse save(GroupRequestDto groupRequestDto) {
        groupRequestDto.setCourse(courseRepository.getById(groupRequestDto.getCourseId()));
        Group group = groupMapper.convert(groupRequestDto);
        Group group1 = groupRepository.save(group);
        log.info("successful save group:{}", group);
        return groupMapper.deConvert(group1);
    }

    @Override
    public List<GroupResponse> findAll() {
        log.info("find all group:{}", getGroupMapper);
        return groupRepository.findAll().stream()
                .map(groupMapper::deConvert).toList();
    }

    @Override
    public GetGroupDto findBy(Long id) {
        if (id != null) {
            Group group = findById(id);
            log.info("successful find by Id:{}",id);
            return getGroupMapper.convert(group);
        } else {
            throw new NotFoundException(
                    String.format("not found=%s id", id)
            );
        }
    }

    private Group findById(Long id) {
        return groupRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(
                        String.format("client with id = %s does not exists", id)
                ));
    }


    @Override
    @Transactional
    public GroupResponse update(Long id, GroupRequestDto groupRequestDto) {
        Group group = findById(id);
        String currentGroupName = group.getGroupName();
        String newGroupName = groupRequestDto.getGroupName();
        if (!currentGroupName.equals(newGroupName)) {
            group.setGroupName(newGroupName);
        }
        log.info("successful update courseId:{}",id);
        return groupMapper.deConvert(group);
    }

    @Override
    public SimpleResponse deleteById(Long id) {
        boolean exists = groupRepository.existsById(id);
        if (!exists) {
            throw new NotFoundException(
                    "Group with id = "+id+ " not found!");
        }
        Group group = groupRepository.findById(id).orElseThrow();
        group.getCourses().forEach(u -> u.getGroups().remove(group));
        courseRepository.saveAll(group.getCourses());
        groupRepository.delete(group);
        return new SimpleResponse(
                "DELETED", "Successfully deleted"
        );
    }

    @Override
    public GroupResponse getById(Long id) {
        return groupMapper.deConvert(groupRepository.getById(id));
    }
}

