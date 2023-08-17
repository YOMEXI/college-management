package collegemanagement.person.other.healthrecord;

import collegemanagement.person.other.healthrecord.dto.createHealthRecord;
import collegemanagement.person.other.healthrecord.dto.healthRecordResponse;

public interface HealthRecordService {
    HealthRecord newRecord (createHealthRecord record);
}
