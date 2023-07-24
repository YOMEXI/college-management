package collegemanagement.student;

import collegemanagement.student.dto.createStudentDto;
import collegemanagement.student.dto.studentResponseDto;

public interface StudentService {
    studentResponseDto createStudent(createStudentDto createStudentDto);
}
