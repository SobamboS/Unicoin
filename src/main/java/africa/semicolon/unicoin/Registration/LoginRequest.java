package africa.semicolon.unicoin.Registration;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class LoginRequest{
    private String emailAddress;
    private String password;
}
