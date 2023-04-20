package bg.softuni.armory.repository;

import bg.softuni.armory.model.entity.wmd.NuclearRocketEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NuclearRocketRepository extends JpaRepository<NuclearRocketEntity, Long> {
}
