package kg.seit.company_project_rest_api_jwt.dto.user;

import lombok.Getter;
import lombok.Setter;

/**
 * @author seiitbeknarynbaev
 */
@Getter
@Setter
public class UserRequestDto {
    private String email;
    private String password;
}
