package collegemanagement.auth.role;

import collegemanagement.auth.role.dto.createRole;
import collegemanagement.auth.role.dto.roleResponse;
import collegemanagement.shared.exception.CustomApiException;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RoleServiceImpl implements RoleService {

    private final  RoleRepository roleRepository;
    private final ModelMapper modelMapper;

    public RoleServiceImpl( RoleRepository roleRepository, ModelMapper modelMapper) {

        this.roleRepository = roleRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public roleResponse createRole(createRole role) {

        Optional<RoleEntity> ifRoleExist = roleRepository.findByName(role.getName());

        if (ifRoleExist.isPresent())
            throw new CustomApiException(HttpStatus.BAD_REQUEST,
                    "Role Already Exists");


        RoleEntity newRole = new RoleEntity();
        newRole.setName(role.getName());


        roleRepository.save(newRole);
        return modelMapper.map(newRole,roleResponse.class);
    }

    @Override
    public  List<roleResponse> allRoles() {

        List<RoleEntity> allFaculties = roleRepository.findAll();
        var mappedRole = allFaculties.stream()
                .map(role -> modelMapper.map(role, roleResponse.class))
                .collect(Collectors.toList());

        return  mappedRole;
    }

    @Override
    public RoleEntity oneRole(String id) {

        var role = roleRepository.findById(Integer.parseInt(id))
                .orElseThrow(()->new CustomApiException(
                        HttpStatus.BAD_REQUEST,"Role doesnt exist"
                ));

        return role;
    }


}
