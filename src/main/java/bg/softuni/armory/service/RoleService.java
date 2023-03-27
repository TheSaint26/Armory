package bg.softuni.armory.service;

import bg.softuni.armory.model.entity.user.RoleEntity;
import bg.softuni.armory.model.enums.AccountRole;
import bg.softuni.armory.repository.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class RoleService {
    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public void seedRoles() {
        if (roleRepository.count() > 0) {
            return;
        }
        List<RoleEntity> roleList = Arrays.stream(AccountRole.values())
                .map(r -> new RoleEntity().setName(r)).toList();

        roleRepository.saveAll(roleList);
    }
}
