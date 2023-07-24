package collegemanagement.faculty;

import collegemanagement.faculty.dto.createFaculty;
import collegemanagement.faculty.dto.facultyResponse;

import java.util.List;

public interface FacultyService {

    public facultyResponse createFaculty (createFaculty createFaculty);
    public List<facultyResponse> allFaculty ();
}

