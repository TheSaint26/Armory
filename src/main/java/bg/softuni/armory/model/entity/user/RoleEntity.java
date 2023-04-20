package bg.softuni.armory.model.entity.user;

import bg.softuni.armory.model.entity.BaseEntity;
import bg.softuni.armory.model.enums.AccountRole;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
public class RoleEntity extends BaseEntity {

    @Enumerated(EnumType.STRING)
    private AccountRole name;

    public RoleEntity() {
    }

    public AccountRole getName() {
        return name;
    }

    public RoleEntity setName(AccountRole name) {
        this.name = name;
        return this;
    }
}
