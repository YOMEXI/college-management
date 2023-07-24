package collegemanagement.faculty.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class createFaculty {

    private String facultyName;

    private String facultyCode;
}
