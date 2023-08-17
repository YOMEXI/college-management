package collegemanagement.shared.security;

import collegemanagement.person.staff.Staff;
import collegemanagement.person.staff.StaffRepository;
import collegemanagement.person.student.Student;
import collegemanagement.person.student.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final StaffRepository staffRepository;
    private final StudentRepository studentRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {


            Optional<Student> StudentOptional  = studentRepository.findByEmail(username);

            if (StudentOptional.isPresent()){
                return  StudentOptional.get();
            }

            Optional<Staff> StaffOptional  = staffRepository.findByEmail(username);

            if (StaffOptional.isPresent()){
                return  StaffOptional.get();
            }

            throw new UsernameNotFoundException("User not found");

    }
}
