package bg.softuni.armory.service;

import bg.softuni.armory.model.entity.user.UserEntity;
import bg.softuni.armory.model.entity.user.UserLoginDTO;
import bg.softuni.armory.model.entity.user.UserRegisterDTO;
import bg.softuni.armory.model.enums.AccountRole;
import bg.softuni.armory.repository.RoleRepository;
import bg.softuni.armory.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final ModelMapper modelMapper;
    private final UserDetailsService userDetailsService;
    private final RoleRepository roleRepository;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, ModelMapper modelMapper, UserDetailsService userDetailsService, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.modelMapper = modelMapper;
        this.userDetailsService = userDetailsService;
        this.roleRepository = roleRepository;
    }

    public boolean register(UserRegisterDTO userRegisterDTO) {
        if (!userRegisterDTO.getPassword().equals(userRegisterDTO.getConfirmPassword())) {
            System.out.println("Passwords don't match!");
            return false;
        }
        UserEntity newUser = modelMapper.map(userRegisterDTO, UserEntity.class);
        newUser.setPassword(passwordEncoder.encode(userRegisterDTO.getPassword()));
        newUser.setRegisteredOn(LocalDate.now());
        if (userRepository.count() == 0) {
            newUser.setRoles(roleRepository.findAll());
        } else {
            newUser.addRole(roleRepository.findByName(AccountRole.USER));
        }
        userRepository.save(newUser);
        return true;
    }

   private void login(UserLoginDTO user) {
       UserDetails userDetails =
               userDetailsService.loadUserByUsername(user.getEmail());

       Authentication authentication =
               new UsernamePasswordAuthenticationToken(
                       userDetails,
                       userDetails.getPassword(),
                       userDetails.getAuthorities()
               );

       SecurityContextHolder
               .getContext()
               .setAuthentication(authentication);
   }
}
