package africa.semicolon.unicoin.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;

    @Override
    public String createAccount(User user){
        userRepository.save(user);
        return "Created";
    }
}