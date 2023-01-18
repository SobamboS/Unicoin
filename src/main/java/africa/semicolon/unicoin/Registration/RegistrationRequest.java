package africa.semicolon.unicoin.Registration;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

public class RegistrationRequest{
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String password;
}
