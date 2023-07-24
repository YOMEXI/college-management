package collegemanagement.department;

import collegemanagement.department.dto.createDepartment;
import collegemanagement.department.dto.departmentResponse;
import collegemanagement.faculty.FacultyEntity;
import collegemanagement.faculty.FacultyRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {


    private final DepartmentRepository departmentRepository;
    private final FacultyRepository facultyRepository;
    private final ModelMapper modelMapper;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository, FacultyRepository facultyRepository, ModelMapper modelMapper) {
        this.departmentRepository = departmentRepository;
        this.facultyRepository = facultyRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public departmentResponse createDepartment(createDepartment department) {
        DepartmentEntity newDepartment = new DepartmentEntity();
        newDepartment.setDepartmentName(department.getDepartmentName());
        newDepartment.setDepartmentCode(department.getDepartmentCode());


        Optional<FacultyEntity> departmentFaculty = facultyRepository
                .findById(department.getFacultyId());

        newDepartment.setFaculty(departmentFaculty.get());

        departmentRepository.save(newDepartment);


        return modelMapper.map(newDepartment, departmentResponse.class);
    }

    @Override
    public List<departmentResponse> allDepartments() {

        List<DepartmentEntity> allDepartments =departmentRepository.findAll();

        var mappedDepartments= allDepartments.stream()
                .map(department -> modelMapper.map(department, departmentResponse.class))
                .collect(Collectors.toList());

        return mappedDepartments ;
    }
}
