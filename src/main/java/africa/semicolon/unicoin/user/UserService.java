package africa.semicolon.unicoin.user;

import africa.semicolon.unicoin.user.dtos.ChangePasswordRequest;

import java.util.Optional;

public interface UserService{
    public String createAccount(User user);

    void  enableUser(String emailAddress);

    public String changePassword(ChangePasswordRequest changePasswordRequest);

}
