package bg.softuni.armory.repository;

import bg.softuni.armory.model.entity.artillery.TrunkArtilleryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrunkArtilleryRepository extends JpaRepository<TrunkArtilleryEntity, Long> {
}
