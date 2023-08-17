package collegemanagement.person.student;

import collegemanagement.auth.role.RoleEntity;
import collegemanagement.person.other.healthrecord.HealthRecord;
import collegemanagement.person.student.enums.ENROLLMENT_STATUS;
import collegemanagement.program.Program;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "student", schema = "college")
@Inheritance(strategy = InheritanceType.JOINED)
public class Student implements UserDetails {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    @NotBlank(message = "first name is mandatory")
    private String firstName;

    @Column(nullable = false)
    @NotBlank(message = "last name is mandatory")
    private String lastName;

    @Column(nullable = false)
    @NotBlank(message = "address is mandatory")
    private String address;

    @Column()
    private String middleName;

    @NotNull(message = "registration Year cannot be empty")
    @Column()
    private Integer yearOfRegistration;

    @Column()
    private Integer yearOfGraduation;

    @Column(nullable = false)
    private String dateOfBirth;

    @Column(nullable = false)
    private String gender;

    @Enumerated(EnumType.STRING)
    private ENROLLMENT_STATUS enrollmentStatus;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "health", referencedColumnName = "email")
    private HealthRecord healthRecord;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "program", referencedColumnName = "id")
    private Program program;

    @NotBlank(message = "password cannot be empty")
    @Column(length = 150,nullable = false)
    private String password;

    @NotBlank(message = "email cannot be empty")
    @Column(length = 50,nullable = false)
    private String email;

    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinTable(
            name = "student_roles",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<RoleEntity> role = new HashSet<>();

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<RoleEntity> roles =  getRole();
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();

        for (RoleEntity role : roles) {

            authorities.add(new SimpleGrantedAuthority(role.getName()));
        }

        return authorities;
    }

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {

        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {

        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
