package africa.semicolon.unicoin.user;

import java.util.Optional;

public interface UserService{
    public String createAccount(User user);

    void  enableUser(String emailAddress);

}
