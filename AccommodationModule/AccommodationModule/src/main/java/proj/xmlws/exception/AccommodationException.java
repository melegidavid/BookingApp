package proj.xmlws.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

public class AccommodationException extends RuntimeException {

    private HttpStatus httpStatus;
    private String message;

    public AccommodationException(HttpStatus httpStatus, String message) {
        this.httpStatus = httpStatus;
        this.message = message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
