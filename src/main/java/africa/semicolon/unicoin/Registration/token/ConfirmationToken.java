package africa.semicolon.unicoin.Registration.token;

import africa.semicolon.unicoin.user.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
public class ConfirmationToken{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private  String token;
    @NotNull
    private LocalDateTime createAt;
    @NotNull
    private  LocalDateTime expiredAt;
    private LocalDateTime confirmedAt;
    @ManyToOne
    @JoinColumn(name="user_id", referencedColumnName="id")
    private User user;

    public ConfirmationToken(String token,
                             LocalDateTime createAt,
                             LocalDateTime expiredAt,
                             User user){
        this.token=token;
        this.createAt=createAt;
        this.expiredAt=expiredAt;
        this.user=user;
    }
}
