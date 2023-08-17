package collegemanagement.person.other.healthrecord;

import collegemanagement.person.other.healthrecord.dto.createHealthRecord;
import collegemanagement.person.other.healthrecord.dto.healthRecordResponse;
import collegemanagement.shared.exception.CustomApiException;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class HealthRecordServiceImpl implements HealthRecordService {

    private final HealthRecordRepository healthRecordRepository;


    public HealthRecordServiceImpl(HealthRecordRepository healthRecordRepository, ModelMapper modelMapper) {
        this.healthRecordRepository = healthRecordRepository;

    }


    @Override
    public HealthRecord newRecord(createHealthRecord record) {

        var ifEmailExist = healthRecordRepository.findByEmail(
                record.getEmail()
        );

        if (ifEmailExist.isPresent())
            throw new CustomApiException(HttpStatus.BAD_REQUEST,"Email Already Exists");

        HealthRecord newRecord = new HealthRecord();

        newRecord.setGenotype(record.getGenotype());
        newRecord.setEmail(record.getEmail());
        newRecord.setHealthIssues(record.getHealthIssues());
        newRecord.setBloodGroup(record.getBloodGroup());


       healthRecordRepository.save(newRecord);


        return newRecord;
    }
}
