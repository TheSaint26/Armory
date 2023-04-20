package bg.softuni.armory.model.entity.firearms;

import bg.softuni.armory.model.enums.FireArmType;

import javax.persistence.*;

@Entity
@Table(name = "machine_gun")
public class MachineGunEntity extends BaseFireArm {
    @Enumerated(EnumType.STRING)
    private FireArmType type = FireArmType.MACHINE_GUN;
    @Column(name = "machine_guns", nullable = false, unique = true)
    private String name;

    public MachineGunEntity() {
    }

    public FireArmType getType() {
        return type;
    }

    public MachineGunEntity setType(FireArmType type) {
        this.type = type;
        return this;
    }

    public String getName() {
        return name;
    }

    public MachineGunEntity setName(String name) {
        this.name = name;
        return this;
    }
}
