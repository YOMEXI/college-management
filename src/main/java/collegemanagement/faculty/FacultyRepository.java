package collegemanagement.faculty;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FacultyRepository extends JpaRepository<FacultyEntity,Integer> {


    Optional<FacultyEntity> findByFacultyName(String name);
}
