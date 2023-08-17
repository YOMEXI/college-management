package collegemanagement.person.staff;

import collegemanagement.auth.role.RoleEntity;
import collegemanagement.person.other.healthrecord.HealthRecord;
import collegemanagement.person.staff.enums.EmployStatus;
import collegemanagement.person.staff.enums.JobRole;
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
@Table(name = "staff", schema = "college")
@Inheritance(strategy = InheritanceType.JOINED)
public class Staff implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(nullable = false)
    @NotBlank(message = "first name is mandatory")
    private String firstName;

    @Column(nullable = false)
    @NotBlank(message = "last name is mandatory")
    private String lastName;

    @Column(nullable = false)
    @NotBlank(message = "last name is mandatory")
    private String middleName;

    @Column(nullable = false)
    private String dateOfBirth;

    @Column(nullable = false)
    @NotNull(message = " Gender cannot be empty")
    private String gender;

    @NotBlank(message = "email cannot be empty")
    @Column(length = 50,nullable = false)
    private String email;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "health", referencedColumnName = "email")
    private HealthRecord healthRecord;

    @NotNull(message = "registration Year cannot be empty")
    @Column()
    private Integer yearOfEmployment;

    @Column()
    private Integer yearOfExit;

    @Enumerated(EnumType.STRING)
    private EmployStatus employmentStatus;

    @Enumerated(EnumType.STRING)
    private JobRole jobRole;

    @NotBlank(message = "password cannot be empty")
    @Column(length = 150,nullable = false)
    private String password;

    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinTable(
            name = "staff_roles",
            joinColumns = @JoinColumn(name = "staff_id"),
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
