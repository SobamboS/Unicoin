package africa.semicolon.unicoin.user;

import java.util.Optional;

public interface UserService{
     String createAccount(User user);

    void  enableUser(String emailAddress);

    Optional<User> findByEmailAddressIgnoreCase(String emailAddress);
}
