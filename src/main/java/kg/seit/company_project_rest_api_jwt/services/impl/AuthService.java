package kg.seit.company_project_rest_api_jwt.services.impl;

import kg.seit.company_project_rest_api_jwt.dto.user.UserRequestDto;
import kg.seit.company_project_rest_api_jwt.dto.user.UserResponse;
import kg.seit.company_project_rest_api_jwt.jwt.JwtUtils;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author seiitbeknarynbaev
 */
@Service
@AllArgsConstructor
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final JwtUtils jwtUtils;

    public UserResponse authenticate(UserRequestDto authRequest) {
        Authentication authentication;

        authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                authRequest.getEmail(),
                authRequest.getPassword()
        ));

        String generatedToken = jwtUtils.generateToken(authentication);

        return UserResponse.builder()
                .email(authRequest.getEmail())
                .token(generatedToken)
                .build();
    }

}
