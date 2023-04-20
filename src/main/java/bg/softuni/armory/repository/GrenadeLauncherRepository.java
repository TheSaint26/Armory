package bg.softuni.armory.repository;

import bg.softuni.armory.model.entity.firearms.GrenadeLauncherEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GrenadeLauncherRepository extends JpaRepository<GrenadeLauncherEntity, Long> {
}
