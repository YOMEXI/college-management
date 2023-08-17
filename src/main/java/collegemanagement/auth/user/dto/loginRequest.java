package collegemanagement.auth.user.dto;

import lombok.Data;

@Data
public class loginRequest {
    private String email;
    private String password;
}
