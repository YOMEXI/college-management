package collegemanagement.auth.user;

import collegemanagement.auth.user.dto.loginRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class UserController {
   private final UserService userService;

    @PostMapping("/student")
    public ResponseEntity<?> studentLogin (@RequestBody loginRequest request){
        return userService.studentLogin(request);
    }

    @PostMapping("/staff")
    public ResponseEntity<?> staffLogin (@RequestBody loginRequest request){
        return userService.staffLogin(request);
    }
}
