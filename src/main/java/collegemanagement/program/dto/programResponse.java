package collegemanagement.program.dto;

import collegemanagement.department.DepartmentEntity;
import lombok.Data;


@Data
public class programResponse {
    private Integer id;
    private String name;

    private DepartmentEntity department;
}
