package kg.seit.company_project_rest_api_jwt.exceptions;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

/**
 * @author seiitbeknarynbaev
 */
@Getter
@Setter
public class ExceptionResponse {
    private HttpStatus status;
    private String exceptionClassName;
    private String message;

    public ExceptionResponse() {
    }

    public ExceptionResponse(HttpStatus status, String exceptionClassName, String message) {
        this.status = status;
        this.exceptionClassName = exceptionClassName;
        this.message = message;
    }
}
