package collegemanagement.person.student.dto;

import collegemanagement.auth.role.RoleEntity;
import collegemanagement.person.other.healthrecord.HealthRecord;
import collegemanagement.person.student.enums.ENROLLMENT_STATUS;
import collegemanagement.program.Program;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

import java.time.LocalDate;
import java.util.Set;

@Data
public class studentResponse {
    private Integer id;
    private String firstName;
    private String lastName;
    private String address;
    private String middleName;
    private String password;
    private String email;
    private Integer yearOfRegistration;
    private Integer yearOfGraduation;
    private Set<RoleEntity> role;
    private String dateOfBirth;
    private HealthRecord health;
    private String gender;
    private Program program;

    @Enumerated(EnumType.STRING)
    private ENROLLMENT_STATUS enrollmentStatus;
}
