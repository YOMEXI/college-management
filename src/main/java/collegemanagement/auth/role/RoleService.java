package collegemanagement.auth.role;

import collegemanagement.auth.role.dto.createRole;
import collegemanagement.auth.role.dto.roleResponse;

import java.util.List;
import java.util.Optional;

public interface RoleService {
    roleResponse createRole(createRole role);
   List<roleResponse> allRoles();

   RoleEntity oneRole(String role);


}
