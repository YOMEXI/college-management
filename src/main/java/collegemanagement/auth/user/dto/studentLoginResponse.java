package collegemanagement.auth.user.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class studentLoginResponse {

    private Integer id;

    private String firstName;
    private String lastName;
    private String email;
    private List<String> roles;
    private String accessToken;


}
