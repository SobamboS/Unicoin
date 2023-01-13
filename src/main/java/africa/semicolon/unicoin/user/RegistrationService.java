package africa.semicolon.unicoin.user;

import org.springframework.stereotype.Service;

@Service
public class RegistrationService{
    public String register(RegistrationRequest registrationRequest){
        return "Registered";
    }
}
