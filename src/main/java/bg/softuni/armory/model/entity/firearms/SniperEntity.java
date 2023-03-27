package bg.softuni.armory.model.entity.firearms;

import bg.softuni.armory.model.enums.FireArmType;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity
@Table(name = "snipers")
public class SniperEntity extends BaseFireArm {
    @Enumerated(EnumType.STRING)
    private FireArmType type = FireArmType.SNIPER;
    private String name;

    public SniperEntity() {
    }

    public FireArmType getType() {
        return type;
    }

    public SniperEntity setType(FireArmType type) {
        this.type = type;
        return this;
    }

    public String getName() {
        return name;
    }

    public SniperEntity setName(String name) {
        this.name = name;
        return this;
    }
}
