package africa.semicolon.unicoin.user;

import africa.semicolon.unicoin.Registration.token.ConfirmationToken;
import africa.semicolon.unicoin.Registration.token.ConfirmationTokenService;
import africa.semicolon.unicoin.user.dtos.ChangePasswordRequest;
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
        String token = UUID.randomUUID().toString();
        ConfirmationToken confirmationToken = new ConfirmationToken(token,
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(10),
                user);

        confirmationTokenService.saveConfirmationToken(confirmationToken);
        return token;
    }

    @Override
    public void enableUser(String emailAddress){
        userRepository.enable(emailAddress);
    }

    @Override
    public String changePassword(ChangePasswordRequest changePasswordRequest) {
        User foundUser = userRepository.findByEmailAddressIgnoreCase(changePasswordRequest.getEmailAddress())
                .orElseThrow(()-> new IllegalStateException("Email not found"));
        if(!changePasswordRequest.getOldPassword().equals(foundUser.getPassword()))
            throw new IllegalStateException("Incorrect password");
        if (!changePasswordRequest.getNewPassword().equals(changePasswordRequest.getConfirmNewPassword()))
            throw new IllegalStateException("passwords do not match");
        foundUser.setPassword(changePasswordRequest.getOldPassword());
        foundUser.setPassword(changePasswordRequest.getNewPassword());
        foundUser.setPassword(changePasswordRequest.getConfirmNewPassword());
        userRepository.save(foundUser);

        return "password changed successfully";
    }
}
