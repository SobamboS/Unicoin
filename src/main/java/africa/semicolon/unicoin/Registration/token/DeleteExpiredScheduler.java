package africa.semicolon.unicoin.Registration.token;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
@RequiredArgsConstructor
public class DeleteExpiredScheduler{
    @Autowired
    private ConfirmationTokenService confirmationTokenService;

    @Scheduled(cron="0 0 0 * * *")
    public void deleteExpiredToken(){
        confirmationTokenService.deleteExpiredToken();
    }

}
