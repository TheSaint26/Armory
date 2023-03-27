package bg.softuni.armory.model.entity.firearms;

import bg.softuni.armory.model.enums.FireArmType;

import javax.persistence.*;

@Entity
@Table(name = "pistols")
public class PistolEntity extends BaseFireArm {
    @Enumerated(EnumType.STRING)
    private FireArmType type;

    public PistolEntity() {
        super();
        this.type = FireArmType.PISTOL;
    }

    public FireArmType getType() {
        return type;
    }

    public PistolEntity setType(FireArmType type) {
        this.type = type;
        return this;
    }
}
