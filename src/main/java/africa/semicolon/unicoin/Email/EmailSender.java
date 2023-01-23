package africa.semicolon.unicoin.Email;

import jakarta.mail.MessagingException;
import org.springframework.scheduling.annotation.Async;

public interface EmailSender{
    @Async
    void send(String to, String email) throws MessagingException;


}
