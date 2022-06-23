package kg.seit.company_project_rest_api_jwt.apis;

import kg.seit.company_project_rest_api_jwt.dto.user.UserRequestDto;
import kg.seit.company_project_rest_api_jwt.dto.user.UserResponse;
import kg.seit.company_project_rest_api_jwt.services.impl.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.PermitAll;

/**
 * @author seiitbeknarynbaev
 */
@RestController
@RequestMapping("/api/authentication")
@AllArgsConstructor
public class UserApi {

    private final AuthService authService;

    @PostMapping
    @PermitAll
    public UserResponse authenticate(@RequestBody UserRequestDto authRequest) {
        return authService.authenticate(authRequest);
    }

}
