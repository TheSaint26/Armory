package bg.softuni.armory.service;

import bg.softuni.armory.model.ArmoryUserDetails;
import bg.softuni.armory.model.entity.user.RoleEntity;
import bg.softuni.armory.model.entity.user.UserEntity;
import bg.softuni.armory.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.stream.Collectors;

public class ArmoryUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    public ArmoryUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findUserByEmail(email)
                .map(this::map)
                .orElseThrow(() -> new UsernameNotFoundException("User with email " + email + " was not found!"));
    }

    private UserDetails map(UserEntity user) {

        return new ArmoryUserDetails(
                user.getEmail(),
                user.getPassword(),
                user.getFullName(),
                user.getRoles()
                        .stream()
                        .map(this::mapAuthority)
                        .collect(Collectors.toList()));
    }

    private GrantedAuthority mapAuthority(RoleEntity role) {
        return new SimpleGrantedAuthority("ROLE_" +
                role.getName());
    }
}
