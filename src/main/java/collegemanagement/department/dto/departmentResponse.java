package collegemanagement.department.dto;

import collegemanagement.faculty.FacultyEntity;
import collegemanagement.program.Program;
import lombok.Data;

import java.util.List;

@Data
public class departmentResponse {
    private Integer id;

    private String departmentName;

    private String departmentCode;

    private FacultyEntity faculty;

    private List<Program> programmes;
}
