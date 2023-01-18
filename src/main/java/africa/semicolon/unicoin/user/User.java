package africa.semicolon.unicoin.user;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@RequiredArgsConstructor
public class User{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private  Long id;
    @NotBlank(message="This field cannot be empty")
    @Email(message="This field requires a valid email address")
    private String emailAddress;

   @NotBlank(message="This field is required")
    private String firstName;

    @NotNull(message="This field is required")
    @NotEmpty(message="This field is required")
    private String lastName;

    private String password;

    @Enumerated(EnumType.STRING)
    private UserRole userRole;


    private Boolean isDisabled = true;

    public User(String emailAddress,String firstName,String lastName,String password,UserRole user){
        this.emailAddress=emailAddress;
        this.firstName= firstName;
        this.lastName= lastName;
        this.password= password;
        this.userRole = user;
    }


}
