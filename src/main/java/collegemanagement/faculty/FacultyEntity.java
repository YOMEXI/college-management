package collegemanagement.faculty;

import collegemanagement.department.DepartmentEntity;
import collegemanagement.shared.entity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.List;
import java.util.Objects;


@Entity
@Table(name = "faculty", schema = "college")
public class FacultyEntity  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    @NotBlank(message = "faculty name is mandatory")
    private String facultyName;



    @Column(nullable = false)
    @NotBlank(message = "faculty code is mandatory")
    private String facultyCode;

    @JsonIgnore
    @OneToMany(mappedBy = "faculty",fetch = FetchType.EAGER,cascade = CascadeType.ALL,orphanRemoval = true)
    private List<DepartmentEntity> departments;

    public FacultyEntity() {
    }

    public FacultyEntity(Integer id, String facultyName, String facultyCode, List<DepartmentEntity> departments) {
        this.id = id;
        this.facultyName = facultyName;
        this.facultyCode = facultyCode;
        this.departments = departments;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFacultyName() {
        return facultyName;
    }

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }

    public String getFacultyCode() {
        return facultyCode;
    }

    public void setFacultyCode(String facultyCode) {
        this.facultyCode = facultyCode;
    }

    public List<DepartmentEntity> getDepartments() {
        return departments;
    }

    public void setDepartments(List<DepartmentEntity> departments) {
        this.departments = departments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FacultyEntity that = (FacultyEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(facultyName, that.facultyName) && Objects.equals(facultyCode, that.facultyCode) && Objects.equals(departments, that.departments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, facultyName, facultyCode, departments);
    }

    @Override
    public String toString() {
        return "FacultyEntity{" +
                "id=" + id +
                ", facultyName='" + facultyName + '\'' +
                ", facultyCode='" + facultyCode + '\'' +
                ", departments=" + departments +
                '}';
    }
}
