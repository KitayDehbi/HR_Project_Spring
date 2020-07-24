package dehbi.hr.helpers;

import dehbi.hr.Validation.Authentication;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@Authentication
public class AuthUser {
    @NotEmpty(message = "email cannot be empty")
    private String email;
    @NotEmpty (message = "password cannot be empty")
    private String password;

}
