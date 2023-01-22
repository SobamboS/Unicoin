package africa.semicolon.unicoin.user;

import africa.semicolon.unicoin.Utils.ApiResponse;
import africa.semicolon.unicoin.user.dtos.ChangePasswordRequest;
import jakarta.mail.MessagingException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.ZonedDateTime;

@RestController
@RequestMapping(path = "api/v1/user")
public class UserController {

        @Autowired
        private UserService userService;
        @PatchMapping("/changepassword")
        public ResponseEntity<?> changePassword(@RequestBody ChangePasswordRequest changePasswordRequest,
                                                HttpServletRequest httpServletRequest) throws MessagingException {
            ApiResponse apiResponse = ApiResponse.builder()
                    .status(HttpStatus.OK.value())
                    .data(userService.changePassword(changePasswordRequest))
                    .timeStamp(ZonedDateTime.now())
                    .path(httpServletRequest.getRequestURI())
                    .isSuccessful(true)
                    .build();
            return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.OK);
        }
}
