package collegemanagement.auth.user;

import collegemanagement.auth.user.dto.StaffLoginResponse;
import collegemanagement.auth.user.dto.studentLoginResponse;
import collegemanagement.auth.user.dto.loginRequest;
import collegemanagement.person.staff.StaffRepository;
import collegemanagement.person.student.StudentRepository;
import collegemanagement.shared.exception.CustomApiException;
import collegemanagement.shared.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {



    private final StudentRepository studentRepository;
    private final StaffRepository staffRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    @Override
    public ResponseEntity<?> studentLogin(loginRequest request) {

        var ifStudentExist = studentRepository.findByEmail(request.getEmail())
                .orElseThrow(()->new CustomApiException(
                        HttpStatus.BAD_REQUEST,"Student does not exist"
                ));

        boolean comparePassword = passwordEncoder.matches(request.getPassword()
                ,ifStudentExist.getPassword());


        if(!comparePassword)
            throw new CustomApiException(HttpStatus.BAD_REQUEST,"Bad credentials inputted");


        var authentication =  authenticationManager.authenticate(

                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );



        List<String> roles = authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .toList();


        String jwtToken = jwtService.generateToken(ifStudentExist);

        return ResponseEntity.ok(new studentLoginResponse(
                ifStudentExist.getId(),
                ifStudentExist.getFirstName(),
                ifStudentExist.getLastName(),
                ifStudentExist.getEmail(),
                roles,
                jwtToken
        ));
    }

    @Override
    public ResponseEntity<?> staffLogin(loginRequest request) {


        var ifStaffExist = staffRepository.findByEmail(request.getEmail())
                .orElseThrow(()->new CustomApiException(
                        HttpStatus.BAD_REQUEST,"Staff does not exist"
                ));

        boolean comparePassword = passwordEncoder.matches(request.getPassword()
                ,ifStaffExist.getPassword());


        if(!comparePassword)
            throw new CustomApiException(HttpStatus.BAD_REQUEST,"Bad credentials inputted");


        var authentication =  authenticationManager.authenticate(

                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );



        List<String> roles = authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .toList();


        String jwtToken = jwtService.generateToken(ifStaffExist);

        return ResponseEntity.ok(new StaffLoginResponse(
                ifStaffExist.getId(),
                ifStaffExist.getFirstName(),
                ifStaffExist.getLastName(),
                ifStaffExist.getEmail(),
                roles,
                jwtToken
        ));
    }
}
