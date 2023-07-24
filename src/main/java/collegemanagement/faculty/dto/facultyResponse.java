package collegemanagement.faculty.dto;

import collegemanagement.department.DepartmentEntity;
import lombok.Data;

import java.util.List;

@Data
public class facultyResponse {

    private Integer id;

    private String facultyName;

    private String facultyCode;

    private List<DepartmentEntity> departments;
}
