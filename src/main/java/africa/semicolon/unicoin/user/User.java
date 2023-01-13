package africa.semicolon.unicoin.user;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
public class User{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private  Long id;
    @NotNull(message="This field is required")
    @NotEmpty(message="This field is required")
    @Email(message="This field requires a valid email address")
    private String emailAddress;

    @NotNull(message="This field is required")
    @NotEmpty(message="This field is required")
    private String firstName;

    @NotNull(message="This field is required")
    @NotEmpty(message="This field is required")
    private String lastName;

    private String password;

    @Enumerated(EnumType.STRING)
    private UserRole userRole;

    private Boolean isDisabled;
}
