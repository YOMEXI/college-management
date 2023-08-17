package collegemanagement.person.student.dto;

import collegemanagement.auth.role.RoleEntity;
import collegemanagement.person.other.healthrecord.dto.createHealthRecord;
import collegemanagement.person.student.enums.ENROLLMENT_STATUS;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

import java.time.LocalDate;

@Data
public class createStudent {

    private String firstName;


    private String lastName;


    private String address;


    private String middleName;


    private Integer yearOfRegistration;


    private Integer yearOfGraduation;

    private String dateOfBirth;

    private String gender;
    private String email;
    private String password;

    private ENROLLMENT_STATUS enrollmentStatus;

    private createHealthRecord healthRecord;
    private Integer programId;
}
