package collegemanagement.person.student;

import collegemanagement.person.student.dto.createStudent;
import collegemanagement.person.student.dto.studentResponse;


public interface StudentService {

    studentResponse newStudent(createStudent student);

}
