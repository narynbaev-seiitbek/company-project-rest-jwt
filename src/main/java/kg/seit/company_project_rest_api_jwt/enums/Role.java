package kg.seit.company_project_rest_api_jwt.enums;

import org.springframework.security.core.GrantedAuthority;

/**
 * @author seiitbeknarynbaev
 */
public enum Role implements GrantedAuthority {

    ADMIN,
    TEACHER,
    STUDENT;

    @Override
    public String getAuthority() {
        return this.name();
    }
}
