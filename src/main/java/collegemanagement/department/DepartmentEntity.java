package collegemanagement.department;

import collegemanagement.faculty.FacultyEntity;
import collegemanagement.program.Program;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "department", schema = "college")
public class DepartmentEntity  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    @NotBlank(message = "department name is mandatory")
    private String departmentName;

    @Column(nullable = false)
    @NotBlank(message = "department code is mandatory")
    private String departmentCode;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "faculty", nullable = false)
    private FacultyEntity faculty;


    @JsonIgnore
    @OneToMany(mappedBy = "department",fetch = FetchType.EAGER,cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Program> programmes;


}
