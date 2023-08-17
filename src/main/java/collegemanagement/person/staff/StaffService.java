package collegemanagement.person.staff;

import collegemanagement.person.staff.dto.createStaff;
import collegemanagement.person.staff.dto.staffResponse;

public interface StaffService {
    staffResponse createStaff(createStaff staff);
}
