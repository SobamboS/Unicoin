package africa.semicolon.unicoin.Email;

import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailService implements EmailSender{

    private JavaMailSender javaMailSender;

    @Override
    public void send(String to, String email) throws MessagingException{
        MineMessage mailMessage = javaMailSender.createMimeMessage();
        MineMessageHelper mineMessageHelper = new MimeMessageHelper(mailMessage, );

    }
}