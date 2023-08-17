package collegemanagement.person.staff.dto;

import collegemanagement.auth.role.RoleEntity;
import collegemanagement.person.other.healthrecord.dto.createHealthRecord;
import collegemanagement.person.staff.enums.EmployStatus;
import collegemanagement.person.staff.enums.JobRole;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
public class createStaff {

    private String firstName;

    private String lastName;

    private String middleName;

    private String dateOfBirth;

    private String gender;

    private String email;
    private createHealthRecord healthRecord;
    private Integer roleId;
    private Integer yearOfEmployment;


    @Enumerated(EnumType.STRING)
    private EmployStatus employmentStatus;

    @Enumerated(EnumType.STRING)
    private JobRole jobRole;

    private String password;

}
