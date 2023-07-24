package collegemanagement.shared.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

@Getter
@Setter
@MappedSuperclass
public abstract class BaseEntity<T> implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private T id;

    @CreatedDate
    private Instant createdDate;
    public BaseEntity() {
    }

    public BaseEntity(T id, Instant createdDate) {
        this.id = id;
        this.createdDate = createdDate;
    }

    public T getId() {
        return id;
    }

    public void setId(T id) {
        this.id = id;
    }

    public Instant getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Instant createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseEntity<?> that = (BaseEntity<?>) o;
        return Objects.equals(id, that.id) && Objects.equals(createdDate, that.createdDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, createdDate);
    }

    @Override
    public String toString() {
        return "BaseEntity{" +
                "id=" + id +
                ", createdDate=" + createdDate +
                '}';
    }
}
