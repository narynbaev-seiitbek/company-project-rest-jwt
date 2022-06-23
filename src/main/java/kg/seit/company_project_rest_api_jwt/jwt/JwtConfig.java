package kg.seit.company_project_rest_api_jwt.jwt;

import kg.seit.company_project_rest_api_jwt.exceptions.SimpleResponse;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

/**
 * @author seiitbeknarynbaev
 */
@Component
@Getter
@Setter
@ConfigurationProperties(prefix = "app.jwt")
public class JwtConfig {

    private String secretKey;
    private String tokenPrefix;
    private Long expirationDateAfterDays;

    public void setTokenExpirationAfterDays(Long tokenExpirationAfterDays) {
        this.expirationDateAfterDays = tokenExpirationAfterDays * 6500000;
    }

    public String getAuthorizationHeader() {
        return HttpHeaders.AUTHORIZATION;
    }

}
