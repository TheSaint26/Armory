package bg.softuni.armory.repository;

import bg.softuni.armory.model.entity.firearms.SniperEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SniperRepository extends JpaRepository<SniperEntity, Long> {
}
