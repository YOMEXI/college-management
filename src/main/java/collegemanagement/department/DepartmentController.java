package collegemanagement.department;
import collegemanagement.department.dto.createDepartment;
import collegemanagement.department.dto.departmentResponse;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/department")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping()
    public departmentResponse createDepartment(@Validated @RequestBody createDepartment request){
        return departmentService.createDepartment(request);
    }

    @GetMapping()
    public List<departmentResponse> getAllDepartments(){
        return departmentService.allDepartments();
    }
}
