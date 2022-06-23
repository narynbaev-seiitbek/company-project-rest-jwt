package kg.seit.company_project_rest_api_jwt.dto.group;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

/**
 * @author seiitbeknarynbaev
 */
@Getter
@Setter
public class GetGroupDto {
    private Long id;
    private String groupName;
    private LocalDate dateOfStart;
    private LocalDate dateOfFinish;


}
