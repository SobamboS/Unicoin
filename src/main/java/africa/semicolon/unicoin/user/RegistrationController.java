package africa.semicolon.unicoin.user;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="api/v1/registration")
public class RegistrationController{

    RegistrationService registrationService;

    @PostMapping("/register")
    public String register(RegistrationRequest registrationRequest){
       return registrationService.register(registrationRequest);
    }
}
