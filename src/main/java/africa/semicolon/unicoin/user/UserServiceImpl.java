package africa.semicolon.unicoin.user;

import africa.semicolon.unicoin.Registration.token.ConfirmationToken;
import africa.semicolon.unicoin.Registration.token.ConfirmationTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ConfirmationTokenService confirmationTokenService;

    @Override
    public String createAccount(User user){
        userRepository.save(user);

        String token =UUID.randomUUID().toString();
        ConfirmationToken confirmationToken = new ConfirmationToken(
                token,
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(10)
        );

        ConfirmationTokenService.saveConfirmationToken(confirmationToken);
        return "Created";
    }
}
