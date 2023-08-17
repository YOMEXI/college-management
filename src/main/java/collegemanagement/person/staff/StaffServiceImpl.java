package collegemanagement.person.staff;

import collegemanagement.auth.role.RoleService;
import collegemanagement.person.other.healthrecord.HealthRecord;
import collegemanagement.person.other.healthrecord.HealthRecordService;
import collegemanagement.person.staff.dto.createStaff;
import collegemanagement.person.staff.dto.staffResponse;
import collegemanagement.person.student.dto.studentResponse;
import collegemanagement.shared.exception.CustomApiException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class StaffServiceImpl implements StaffService {
    private final RoleService roleService;
    private final HealthRecordService healthRecordService;
    private final StaffRepository staffRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public staffResponse createStaff(createStaff staff) {

        if(staffRepository.findByEmail(staff.getEmail()).isPresent())
            throw  new CustomApiException(HttpStatus.BAD_REQUEST,
                    "Staff with email already Exist");

        var newStaff = new Staff();
        newStaff.setEmploymentStatus(staff.getEmploymentStatus());
        newStaff.setEmail(staff.getEmail());
        newStaff.setLastName(staff.getLastName());
        newStaff.setFirstName(staff.getFirstName());
        newStaff.setMiddleName(staff.getMiddleName());
        newStaff.setJobRole(staff.getJobRole());
        newStaff.setYearOfEmployment(staff.getYearOfEmployment());
        newStaff.setDateOfBirth(staff.getDateOfBirth());
        newStaff.setPassword(passwordEncoder.encode(staff.getPassword()));
        newStaff.setGender(staff.getGender());

        var role = roleService.oneRole(String.valueOf(staff.getRoleId()));

        HealthRecord healthRecord = healthRecordService.newRecord(staff.getHealthRecord());

     newStaff.setHealthRecord(healthRecord);
        newStaff.setRole(Collections.singleton(role));


        staffRepository.save(newStaff);

        return modelMapper.map(newStaff, staffResponse.class);
    }
}
