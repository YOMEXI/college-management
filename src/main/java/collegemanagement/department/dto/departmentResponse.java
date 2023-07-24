package collegemanagement.department.dto;

import collegemanagement.faculty.FacultyEntity;
import lombok.Data;

@Data
public class departmentResponse {
    private Integer id;

    private String departmentName;

    private String departmentCode;

    private FacultyEntity faculty;
}
