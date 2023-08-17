package collegemanagement.auth.role;

import collegemanagement.auth.role.dto.createRole;
import collegemanagement.auth.role.dto.roleResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequiredArgsConstructor
@PreAuthorize("hasAnyRole('SUPERUSER')")
@RequestMapping("/api/v1/role")
public class RoleController {

    private final RoleService roleService;


    @PostMapping()
    public roleResponse createRole(@RequestBody createRole role){
       return roleService.createRole(role);

    }

    @GetMapping()
    public List<roleResponse> allRoles(){
        return roleService.allRoles();

    }

    @GetMapping("/get")
    public RoleEntity oneRole(@RequestParam(name = "id") String id){
        return roleService.oneRole(id);

    }
}
