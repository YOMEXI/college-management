package collegemanagement.department;
import collegemanagement.department.dto.createDepartment;
import collegemanagement.department.dto.departmentResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v1/department")
@RequiredArgsConstructor
public class DepartmentController {

    private final DepartmentService departmentService;


    @PostMapping()
    @PreAuthorize("hasAnyRole('SUPERUSER')")
    public departmentResponse createDepartment(@Validated @RequestBody createDepartment request){
        return departmentService.createDepartment(request);
    }

    @GetMapping()
    public List<departmentResponse> getAllDepartments(){
        return departmentService.allDepartments();
    }
}
