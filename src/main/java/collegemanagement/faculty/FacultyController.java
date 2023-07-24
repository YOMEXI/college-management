package collegemanagement.faculty;

import collegemanagement.faculty.dto.createFaculty;
import collegemanagement.faculty.dto.facultyResponse;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/faculty")
public class FacultyController {

    private final FacultyService facultyService;

    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    @PostMapping()
    public facultyResponse createFaculty(@Validated @RequestBody createFaculty faculty){
        return facultyService.createFaculty(faculty);
    }

    @GetMapping()
    public List<facultyResponse> getAllFaculties(){
        return facultyService.allFaculty();
    }
}
