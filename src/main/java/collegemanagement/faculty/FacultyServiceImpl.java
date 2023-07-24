package collegemanagement.faculty;

import collegemanagement.faculty.dto.createFaculty;
import collegemanagement.faculty.dto.facultyResponse;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FacultyServiceImpl implements FacultyService {

   private final FacultyRepository facultyRepository;
   private final ModelMapper modelMapper;

    public FacultyServiceImpl(FacultyRepository facultyRepository, ModelMapper modelMapper) {

        this.facultyRepository = facultyRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public facultyResponse createFaculty(createFaculty faculty) {

        List departmentList =new ArrayList();

        FacultyEntity newFaculty = new FacultyEntity();
        newFaculty.setFacultyCode(faculty.getFacultyCode());
        newFaculty.setFacultyName(faculty.getFacultyName());
        newFaculty.setDepartments(departmentList);


        facultyRepository.save(newFaculty);


        return  modelMapper.map(newFaculty, facultyResponse.class);
    }

    @Override
    public List<facultyResponse> allFaculty() {

        List <FacultyEntity> allFaculties = facultyRepository.findAll();

        var mappedFaculties=allFaculties.stream()
                .map(faculty -> modelMapper.map(faculty, facultyResponse.class))
                .collect(Collectors.toList());

        return  mappedFaculties;
    }
}
