package collegemanagement.person.student;


import collegemanagement.person.student.dto.createStudent;
import collegemanagement.person.student.dto.studentResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v1/student")
@RequiredArgsConstructor
@PreAuthorize("hasAnyRole('SUPERUSER')")
public class StudentController {

    private final StudentService studentService;


    @PostMapping()
    public studentResponse newStudent (@Validated @RequestBody createStudent student){

        return studentService.newStudent(student);

    }


}
