package bg.softuni.armory.repository;

import bg.softuni.armory.model.entity.firearms.PistolEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PistolRepository extends JpaRepository<PistolEntity, Long> {
}
