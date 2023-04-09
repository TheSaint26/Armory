package bg.softuni.armory.service;

import bg.softuni.armory.model.entity.user.UserDTO;
import bg.softuni.armory.model.entity.user.UserEntity;
import bg.softuni.armory.model.entity.user.UserLoginDTO;
import bg.softuni.armory.model.entity.user.UserRegisterDTO;
import bg.softuni.armory.model.entity.views.WeaponPictureAndNameViewDTO;
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

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
            newUser.setActive(true);
        } else {
            newUser.addRole(roleRepository.findByName(AccountRole.USER));
        }
        userRepository.save(newUser);
        return true;
    }

//   private void login(UserLoginDTO user) {
//       UserDetails userDetails =
//               userDetailsService.loadUserByUsername(user.getUsername());
//
//       Authentication authentication =
//               new UsernamePasswordAuthenticationToken(
//                       userDetails,
//                       userDetails.getPassword(),
//                       userDetails.getAuthorities()
//               );
//
//       SecurityContextHolder
//               .getContext()
//               .setAuthentication(authentication);
//   }

   public List<WeaponPictureAndNameViewDTO> getAllWeapons(UserDetails userDetails) {
        UserEntity user = userRepository.findUserEntityByUsername(userDetails.getUsername()).orElseThrow();
        List<WeaponPictureAndNameViewDTO> weaponsList = new ArrayList<>();

        user.getBoughtPistols()
                .stream()
                .map(p -> modelMapper.map(p, WeaponPictureAndNameViewDTO.class))
                .forEach(weaponsList::add);

        user.getBoughtAssaultRifles()
                .stream()
                .map(ar -> modelMapper.map(ar, WeaponPictureAndNameViewDTO.class))
                .forEach(weaponsList::add);

        user.getBoughtMachineGuns()
                .stream()
                .map(mg -> modelMapper.map(mg, WeaponPictureAndNameViewDTO.class))
                .forEach(weaponsList::add);

        user.getBoughtSnipers()
                .stream()
                .map(s -> modelMapper.map(s, WeaponPictureAndNameViewDTO.class))
                .forEach(weaponsList::add);

        user.getBoughtGrenadeLaunchers()
                .stream()
                .map(gl -> modelMapper.map(gl, WeaponPictureAndNameViewDTO.class))
                .forEach(weaponsList::add);

        user.getBoughtIfvs()
                .stream()
                .map(ifv -> modelMapper.map(ifv, WeaponPictureAndNameViewDTO.class))
                .forEach(weaponsList::add);

        user.getBoughtTanks()
                .stream()
                .map(t -> modelMapper.map(t, WeaponPictureAndNameViewDTO.class))
                .forEach(weaponsList::add);

        user.getBoughtTrunkArtillery()
                .stream()
                .map(trunkArtilleryEntity -> modelMapper.map(trunkArtilleryEntity, WeaponPictureAndNameViewDTO.class))
                .forEach(weaponsList::add);

        user.getBoughtRocketArtillery()
                .stream()
                .map(rocketArtilleryEntity -> modelMapper.map(rocketArtilleryEntity, WeaponPictureAndNameViewDTO.class))
                .forEach(weaponsList::add);

        user.getBoughtAircraft()
                .stream()
                .map(aircraftEntity -> modelMapper.map(aircraftEntity, WeaponPictureAndNameViewDTO.class))
                .forEach(weaponsList::add);

        return weaponsList;
   }

   public List<UserDTO> getOtherUsers(String username) {
        List<UserEntity> users = userRepository.getAllByUsernameNot(username);
        List<UserDTO> dtos = new ArrayList<>();
       for (UserEntity u : users) {
           dtos.add(map(u));
       }
       return dtos;
   }

   private UserDTO map(UserEntity user) {
       return new UserDTO()
               .setId(user.getId())
               .setUsername(user.getUsername())
               .setFullName(user.getFullName())
               .setModerator(user.getRoles().contains(roleRepository.findByName(AccountRole.MODERATOR)))
               .setActive(user.isActive());
   }

   public void deactivateUser(Long id) {
        UserEntity user = userRepository.findById(id).orElseThrow();
        user.setActive(false);
        userRepository.save(user);
   }

   public void activateUser(Long id) {
        UserEntity user = userRepository.findById(id).orElseThrow();
        user.setActive(true);
        userRepository.save(user);
   }

   public void giveModeratorPrivileges(Long id) {
       UserEntity user = userRepository.findById(id).orElseThrow();
       if (!user.isActive()) {
           throw new IllegalStateException("User must be active!");
       }
       user.getRoles().add(roleRepository.findByName(AccountRole.MODERATOR));
       userRepository.save(user);
   }

   public void takeModeratorPrivileges(Long id) {
       UserEntity user = userRepository.findById(id).orElseThrow();
       if (!user.isActive()) {
           throw new IllegalStateException("User must be active!");
       }
       user.getRoles().remove(roleRepository.findByName(AccountRole.MODERATOR));
       userRepository.save(user);
   }
}
