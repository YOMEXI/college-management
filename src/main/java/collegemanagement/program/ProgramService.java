package collegemanagement.program;

import collegemanagement.program.dto.createProgram;
import collegemanagement.program.dto.programResponse;

import java.util.List;

public interface ProgramService {
    programResponse createProgram(createProgram program);
   List<programResponse> allProgram();
   Program oneProgram(Integer id);

    List<programResponse> searchForPrograms(String program);


}
