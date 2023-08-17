package collegemanagement.program;

import collegemanagement.department.DepartmentEntity;
import collegemanagement.department.DepartmentRepository;
import collegemanagement.program.dto.createProgram;
import collegemanagement.program.dto.programResponse;
import collegemanagement.shared.exception.CustomApiException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequestMapping("/api/v1/program")
@RequiredArgsConstructor
public class ProgramServiceImpl implements ProgramService {

    private final ProgramRepository programRepository;
    private final ModelMapper modelMapper;
    private final DepartmentRepository departmentRepository;



    @Override
    public programResponse createProgram(createProgram program) {

        DepartmentEntity department = departmentRepository
                .findById(program.getDeptId())
                .orElseThrow(()->
                        new CustomApiException(HttpStatus.BAD_REQUEST,
                "Department does not exist"));

        Program newProgram = new Program();
        newProgram.setName(program.getName());
        newProgram.setDepartment(department);

        programRepository.save(newProgram);
         return modelMapper.map(newProgram, programResponse.class);
    }

    @Override
    public List<programResponse> allProgram() {

        List<Program> allPrograms = programRepository.findAll();

       var mappedPrograms = allPrograms.stream()
                .map(program -> modelMapper.map(program, programResponse.class))
                .collect(Collectors.toList());

        return mappedPrograms ;
    }

    @Override
    public Program oneProgram(Integer id) {
       return programRepository.findById(id)
               .orElseThrow(()->new CustomApiException(HttpStatus.BAD_REQUEST,
                       "Program doesnt exist"));


    }

    @Override
    public List<programResponse> searchForPrograms(String param) {

        List<Program> Programs = programRepository.searchProgram(param);


        var searchedPrograms = Programs.stream()
                .map(program -> modelMapper.map(program, programResponse.class))
                .collect(Collectors.toList());

        return searchedPrograms ;

    }


}
