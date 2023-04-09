package bg.softuni.armory.repository;

import bg.softuni.armory.model.entity.user.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findUserByEmail(String email);
    Optional<UserEntity> findUserEntityByUsername(String username);

    List<UserEntity> getAllByUsernameNot(String username);
}
