package bg.softuni.armory.model.entity.firearms;

import bg.softuni.armory.model.enums.FireArmType;

import javax.persistence.*;

@Entity
@Table(name = "grenade_launcher")
public class GrenadeLauncherEntity extends BaseFireArm {
    @Enumerated(EnumType.STRING)
    private FireArmType type = FireArmType.GRENADE_LAUNCHER;

    public GrenadeLauncherEntity() {
    }

    public FireArmType getType() {
        return type;
    }

    public GrenadeLauncherEntity setType(FireArmType type) {
        this.type = type;
        return this;
    }
}
