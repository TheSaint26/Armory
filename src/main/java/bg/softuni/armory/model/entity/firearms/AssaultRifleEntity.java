package bg.softuni.armory.model.entity.firearms;

import bg.softuni.armory.model.enums.FireArmType;

import javax.persistence.*;

@Entity
@Table(name = "assault_rifles")
public class AssaultRifleEntity extends BaseFireArm {
    @Enumerated(EnumType.STRING)
    private FireArmType type = FireArmType.ASSAULT_RIFLE;


    public AssaultRifleEntity() {
    }

    public FireArmType getType() {
        return type;
    }

    public AssaultRifleEntity setType(FireArmType type) {
        this.type = type;
        return this;
    }
}
