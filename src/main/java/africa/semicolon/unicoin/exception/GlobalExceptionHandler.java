package africa.semicolon.unicoin.exception;

public class GlobalExceptionHandler{
}
package africa.unicoin.unicoin.exception;

        import africa.unicoin.unicoin.utils.ApiResponse;
        import jakarta.servlet.http.HttpServletRequest;
        import org.springframework.http.HttpStatus;
        import org.springframework.http.ResponseEntity;
        import org.springframework.web.bind.annotation.ExceptionHandler;
        import org.springframework.web.bind.annotation.RestControllerAdvice;

        import java.time.ZonedDateTime;


@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<?> userAlreadyExistException(RegistrationException registrationException,
                                                       HttpServletRequest httpServletRequest){
        ApiResponse apiResponse =  ApiResponse.builder()
                .timestamp(ZonedDateTime.now())
                .status(HttpStatus.BAD_REQUEST.value())
                .isSuccessful(false)
                .path(httpServletRequest.getRequestURI())
                .data(registrationException.getMessage())
                .build();

        return new ResponseEntity<>(apiResponse, HttpStatus.CONFLICT);
    }
}