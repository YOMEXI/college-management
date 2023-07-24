package collegemanagement.student;

import collegemanagement.student.dto.createStudentDto;
import collegemanagement.student.dto.studentResponseDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/student")
public class StudentController {
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    StudentService studentService;

    @PostMapping()
    public studentResponseDto createStudent(createStudentDto request) {


        return null;
    }
}
