package bg.softuni.armory.repository;

import bg.softuni.armory.model.entity.wmd.NuclearBombEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NuclearBombRepository extends JpaRepository<NuclearBombEntity, Long> {
}
