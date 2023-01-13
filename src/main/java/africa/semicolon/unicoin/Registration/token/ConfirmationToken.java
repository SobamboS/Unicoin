package africa.semicolon.unicoin.Registration.token;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@RequiredArgsConstructor
public class ConfirmationToken{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String token;
    private LocalDateTime createAt;
    private LocalDateTime expiredAt;
    private LocalDateTime confirmedAt;

}
