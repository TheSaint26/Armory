package bg.softuni.armory.repository;

import bg.softuni.armory.model.entity.aircraft.AircraftEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AircraftRepository extends JpaRepository<AircraftEntity, Long> {
}
