package collegemanagement.department.dto;

import lombok.Data;

@Data
public class createDepartment {

    private String departmentName;

    private String departmentCode;

    private Integer facultyId;
}
