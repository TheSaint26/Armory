package bg.softuni.armory.repository;

import bg.softuni.armory.model.entity.firearms.MachineGunEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MachineGunRepository extends JpaRepository<MachineGunEntity, Long> {
}
