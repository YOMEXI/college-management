package collegemanagement.person.student;

import collegemanagement.auth.role.ROLE_CONSTANTS;
import collegemanagement.auth.role.RoleRepository;
import collegemanagement.auth.role.RoleService;
import collegemanagement.person.other.healthrecord.HealthRecordRepository;
import collegemanagement.person.other.healthrecord.HealthRecordService;
import collegemanagement.person.student.dto.createStudent;
import collegemanagement.person.student.dto.studentResponse;
import collegemanagement.person.student.enums.ENROLLMENT_STATUS;
import collegemanagement.program.ProgramService;
import collegemanagement.shared.exception.CustomApiException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final RoleRepository roleRepository;
    private final RoleService roleService;
    private final StudentRepository studentRepository;
    private final HealthRecordService healthRecordService;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;
    private final ProgramService programService;



    @Override
    public studentResponse newStudent(createStudent student) {

        if(studentRepository.findByEmail(student.getEmail()).isPresent())
            throw  new CustomApiException(HttpStatus.BAD_REQUEST,
                    "Student with email already Exist");

       var program =programService.oneProgram(student.getProgramId());

        Student newStudent = new Student();
        newStudent.setAddress(student.getAddress());
        newStudent.setGender(student.getGender());
        newStudent.setDateOfBirth(student.getDateOfBirth());
        newStudent.setEnrollmentStatus(ENROLLMENT_STATUS.PROBATION);
        newStudent.setFirstName(student.getFirstName());
        newStudent.setLastName(student.getLastName());
        newStudent.setMiddleName(student.getMiddleName());
        newStudent.setYearOfRegistration(student.getYearOfRegistration());
        newStudent.setEmail(student.getEmail());
        newStudent.setPassword(passwordEncoder.encode(student.getPassword()));
        newStudent.setProgram(program);

       var role = roleService.oneRole(String.valueOf(ROLE_CONSTANTS.student_role_id));

       var healthRecord = healthRecordService.newRecord(student.getHealthRecord());

       newStudent.setHealthRecord(healthRecord);
        newStudent.setRole(Collections.singleton(role));


        studentRepository.save(newStudent);

        return modelMapper.map(newStudent, studentResponse.class);
    }
}
