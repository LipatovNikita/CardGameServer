package cardgame.bean;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.UUID;

@MappedSuperclass
@Data
public class BaseEntity implements Serializable {

    @Id
    @Column(name = "id", nullable = false, unique = true)
    private String id;

    public BaseEntity() {
        this.id = UUID.randomUUID().toString();
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (!(obj instanceof BaseEntity)) {
            return false;
        }
        BaseEntity other = (BaseEntity) obj;
        return getId().equals(other.getId());
    }
}
