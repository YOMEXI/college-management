package collegemanagement.person.other.healthrecord;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface HealthRecordRepository extends JpaRepository<HealthRecord,Integer> {
    Optional<HealthRecord> findByEmail(String email);
}
