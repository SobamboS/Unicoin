package africa.semicolon.unicoin.Registration;

import africa.semicolon.unicoin.Registration.token.ConfirmTokenRequest;
import africa.semicolon.unicoin.Utils.ApiResponse;
import jakarta.mail.MessagingException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.ZonedDateTime;

@RestController
@RequestMapping(path="api/v1/registration")
public class RegistrationController{
    @Autowired
    RegistrationService registrationService;

    @PostMapping("/register")
    public ResponseEntity<ApiResponse> register(@RequestBody RegistrationRequest registrationRequest,
                                                HttpServletRequest httpServletRequest) throws MessagingException{
     ApiResponse apiResponse = ApiResponse.builder()
             .status(HttpStatus.OK.value())
             .data(registrationService.register(registrationRequest))
             .timeStamp(ZonedDateTime.now())
             .path(httpServletRequest.getRequestURI())
             .isSuccessful(true)
             .build();
       return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.OK);
    }

    @PostMapping("/confirm")
    public ResponseEntity<?> confirmToken(@RequestBody ConfirmTokenRequest confirmTokenRequest,
                                          HttpServletRequest httpServletRequest){
        ApiResponse apiResponse = ApiResponse.builder()
                .status(HttpStatus.OK.value())
                .data(registrationService.confirmToken(confirmTokenRequest))
                .timeStamp(ZonedDateTime.now())
                .path(httpServletRequest.getRequestURI())
                .isSuccessful(true)
                .build();
        return  new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest, HttpServletRequest httpServletRequest){
        ApiResponse apiResponse =ApiResponse.builder()
                .status(HttpStatus.OK.value())
                .data(registrationService.login(loginRequest))
                .timeStamp(ZonedDateTime.now())
                .path(httpServletRequest.getRequestURI())
                .isSuccessful(true)
                .build();
        return  new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }
}
