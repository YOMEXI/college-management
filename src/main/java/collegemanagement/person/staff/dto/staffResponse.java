package collegemanagement.person.staff.dto;

import collegemanagement.person.other.healthrecord.HealthRecord;
import collegemanagement.person.staff.enums.EmployStatus;
import collegemanagement.person.staff.enums.JobRole;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

@Data
public class staffResponse {

    private Integer id;

    private String firstName;

    private String lastName;

    private String middleName;

    private String dateOfBirth;

    private String gender;

    private String email;

    private HealthRecord healthRecord;

    private Integer yearOfEmployment;

    @Enumerated(EnumType.STRING)
    private EmployStatus employmentStatus;

    @Enumerated(EnumType.STRING)
    private JobRole jobRole;


}
