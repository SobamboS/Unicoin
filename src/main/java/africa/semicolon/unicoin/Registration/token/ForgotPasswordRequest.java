package africa.semicolon.unicoin.Registration.token;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class ForgotPasswordRequest{
    private String emailAddress;

}
