package kg.seit.company_project_rest_api_jwt.exceptions;

import lombok.Getter;
import lombok.Setter;

/**
 * @author seiitbeknarynbaev
 */
@Getter
@Setter
public class SimpleResponse {

    private String status;
    private String message;

    public SimpleResponse() {
    }

    public SimpleResponse(String status, String message) {
        this.status = status;
        this.message = message;
    }
}
