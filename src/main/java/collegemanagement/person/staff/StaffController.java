package collegemanagement.person.staff;

import collegemanagement.person.staff.dto.createStaff;
import collegemanagement.person.staff.dto.staffResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/staff")
//@PreAuthorize("hasAnyRole('SUPERUSER')")
public class StaffController {

    private final StaffService staffService;

    @PostMapping()
    public staffResponse createStaff (@Validated @RequestBody createStaff staff){
        return staffService.createStaff(staff);
    }
}
