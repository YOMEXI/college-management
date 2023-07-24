package collegemanagement.department;

import collegemanagement.department.dto.createDepartment;
import collegemanagement.department.dto.departmentResponse;

import java.util.List;

public interface DepartmentService {

    public departmentResponse createDepartment(createDepartment department);
    public List<departmentResponse> allDepartments();
}
