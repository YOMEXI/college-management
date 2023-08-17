package collegemanagement.program;


import collegemanagement.program.dto.createProgram;
import collegemanagement.program.dto.programResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v1/program")
@RequiredArgsConstructor
public class ProgramController {

    private final ProgramService programService;


    @PostMapping()
    @PreAuthorize("hasAnyRole('SUPERUSER')")
    public programResponse createProgram(@Validated @RequestBody createProgram program){
        return programService.createProgram(program);
    }

    @GetMapping()
    public List<programResponse> createProgram(){
        return programService.allProgram();
    }

    @GetMapping("/search")
    public List<programResponse> searchProgram(@RequestParam("q") String q){

        return programService.searchForPrograms(q);
    }
}
