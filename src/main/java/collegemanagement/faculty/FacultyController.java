package collegemanagement.faculty;

import collegemanagement.faculty.dto.createFaculty;
import collegemanagement.faculty.dto.facultyResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v1/faculty")
@RequiredArgsConstructor
public class FacultyController {

    private final FacultyService facultyService;


    @PostMapping()
    @PreAuthorize("hasAnyRole('SUPERUSER')")
    public facultyResponse createFaculty(@Validated @RequestBody createFaculty faculty){
        return facultyService.createFaculty(faculty);
    }

    @GetMapping()
    public List<facultyResponse> getAllFaculties(){
        return facultyService.allFaculty();
    }
}
