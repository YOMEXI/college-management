package collegemanagement.program;

import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ProgramRepository extends JpaRepository<Program,Integer> {



    Optional<Program> findById(Integer id);

    @Query("Select p from Program p where p.name ILike %:name%")
    List<Program> searchProgram(String name);
}
