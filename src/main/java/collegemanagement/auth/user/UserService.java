package collegemanagement.auth.user;

import collegemanagement.auth.user.dto.loginRequest;
import org.springframework.http.ResponseEntity;

public interface UserService {
     ResponseEntity<?> studentLogin(loginRequest request);
     ResponseEntity<?> staffLogin(loginRequest request);
}
