package bg.softuni.armory.repository;

import bg.softuni.armory.model.entity.tank.TankEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TankRepository extends JpaRepository<TankEntity, Long> {
}