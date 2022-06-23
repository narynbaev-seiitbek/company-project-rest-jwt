package kg.seit.company_project_rest_api_jwt.apis;

import io.swagger.v3.oas.annotations.Operation;
import kg.seit.company_project_rest_api_jwt.dto.group.GetGroupDto;
import kg.seit.company_project_rest_api_jwt.dto.group.GroupRequestDto;
import kg.seit.company_project_rest_api_jwt.dto.group.GroupResponse;
import kg.seit.company_project_rest_api_jwt.exceptions.SimpleResponse;
import kg.seit.company_project_rest_api_jwt.services.GroupService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author seiitbeknarynbaev
 */
@RestController
@AllArgsConstructor
@RequestMapping("api/group")
public class GroupApi {
    private final GroupService groupService;

    @PreAuthorize("hasAnyAuthority('ADMIN','TEACHER')")
    @PostMapping("/save")
    @Operation(summary = "save method ", description = "save group")
    public GroupResponse saveGroup(@RequestBody GroupRequestDto groupRequestDto) {
        return groupService.save(groupRequestDto);
    }

    @PreAuthorize("hasAnyAuthority('ADMIN','STUDENT')")
    @GetMapping
    @Operation(summary = "find all groups ", description = "find all groups")
    public List<GroupResponse> findAllGroups() {
        return groupService.findAll();
    }

    @PreAuthorize("hasAnyAuthority('ADMIN','STUDENT')")
    @GetMapping("find/{id}")
    @Operation(summary = "find by id method ", description = "find by id group")
    public GetGroupDto findByIdGroup(@PathVariable Long id) {
        return groupService.findBy(id);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PatchMapping("update/{id}")
    @Operation(summary = "update method ", description = "update group")
    public GroupResponse update(@PathVariable Long id, @RequestBody GroupRequestDto groupRequestDto) {
        return groupService.update(id, groupRequestDto);
    }

    @PreAuthorize("hasAnyAuthority('ADMIN','TEACHER')")
    @DeleteMapping("delete/{id}")
    @Operation(summary = "delete method ", description = "delete group")
    public SimpleResponse deleteByIdGroup(@PathVariable Long id) {
        return groupService.deleteById(id);
    }

}

