package africa.semicolon.unicoin.Registration.token;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
@Transactional
public interface ConfirmationTokenRepository extends JpaRepository<ConfirmationToken, Long>{


    Optional<ConfirmationToken> findByToken(String token);

    void deleteConfirmationTokensByExpiredAtBefore(LocalDateTime currentTime);
}
