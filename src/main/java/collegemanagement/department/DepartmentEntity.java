package collegemanagement.department;

import collegemanagement.faculty.FacultyEntity;
import collegemanagement.shared.entity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.Objects;

@Entity
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


    public DepartmentEntity() {
    }

    public DepartmentEntity(Integer id, String departmentName, String departmentCode, FacultyEntity faculty) {
        this.id = id;
        this.departmentName = departmentName;
        this.departmentCode = departmentCode;
        this.faculty = faculty;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDepartmentCode() {
        return departmentCode;
    }

    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }

    public FacultyEntity getFaculty() {
        return faculty;
    }

    public void setFaculty(FacultyEntity faculty) {
        this.faculty = faculty;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DepartmentEntity that = (DepartmentEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(departmentName, that.departmentName) && Objects.equals(departmentCode, that.departmentCode) && Objects.equals(faculty, that.faculty);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, departmentName, departmentCode, faculty);
    }

    @Override
    public String toString() {
        return "DepartmentEntity{" +
                "id=" + id +
                ", departmentName='" + departmentName + '\'' +
                ", departmentCode='" + departmentCode + '\'' +
                ", faculty=" + faculty +
                '}';
    }
}
