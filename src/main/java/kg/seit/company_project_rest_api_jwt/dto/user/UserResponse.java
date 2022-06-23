package kg.seit.company_project_rest_api_jwt.dto.user;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * @author seiitbeknarynbaev
 */
@Builder
@Getter
@Setter
public class UserResponse {
    private String email;
    private String token;
}
