package cardgame.bean;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "cards")
public class Card extends BaseEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "strength", nullable = false)
    private int strength;

    @Column(name = "rarity", nullable = false)
    private String rarity;

    @Column(name = "isActive", nullable = false)
    private boolean isActive;
}
