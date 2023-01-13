package africa.semicolon.unicoin.Registration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="api/v1/registration")
public class RegistrationController{
@Autowired
    RegistrationService registrationService;

    @PostMapping("/register")
    public String register(@RequestBody RegistrationRequest registrationRequest){
       return registrationService.register(registrationRequest);
    }
}
