package bg.softuni.armory.repository;

import bg.softuni.armory.model.entity.user.RoleEntity;
import bg.softuni.armory.model.enums.AccountRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, Long> {
    RoleEntity findByName(AccountRole role);
}
