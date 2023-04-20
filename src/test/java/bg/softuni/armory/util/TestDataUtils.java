package bg.softuni.armory.util;

import bg.softuni.armory.model.entity.firearms.MachineGunEntity;
import bg.softuni.armory.model.entity.firearms.PistolEntity;
import bg.softuni.armory.model.entity.user.RoleEntity;
import bg.softuni.armory.model.entity.user.UserEntity;
import bg.softuni.armory.model.enums.AccountRole;
import bg.softuni.armory.model.enums.UserType;
import bg.softuni.armory.repository.*;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.stream.Collectors;

@Component
public class TestDataUtils {
    private UserRepository testUserRepository;
    private RoleRepository roleRepository;
    private AircraftRepository aircraftRepository;
    private AssaultRifleRepository assaultRifleRepository;
    private GrenadeLauncherRepository grenadeLauncherRepository;
    private InfantryFightingVehicleRepository infantryFightingVehicleRepository;
    private MachineGunRepository machineGunRepository;
    private PistolRepository pistolRepository;
    private RocketArtilleryRepository rocketArtilleryRepository;
    private TrunkArtilleryRepository trunkArtilleryRepository;
    private TankRepository tankRepository;

    public TestDataUtils(UserRepository userRepository, RoleRepository roleRepository, AircraftRepository aircraftRepository, AssaultRifleRepository assaultRifleRepository, GrenadeLauncherRepository grenadeLauncherRepository, InfantryFightingVehicleRepository infantryFightingVehicleRepository, MachineGunRepository machineGunRepository, PistolRepository pistolRepository, RocketArtilleryRepository rocketArtilleryRepository, TrunkArtilleryRepository trunkArtilleryRepository, TankRepository tankRepository) {
        this.testUserRepository = userRepository;
        this.roleRepository = roleRepository;
        this.aircraftRepository = aircraftRepository;
        this.assaultRifleRepository = assaultRifleRepository;
        this.grenadeLauncherRepository = grenadeLauncherRepository;
        this.infantryFightingVehicleRepository = infantryFightingVehicleRepository;
        this.machineGunRepository = machineGunRepository;
        this.pistolRepository = pistolRepository;
        this.rocketArtilleryRepository = rocketArtilleryRepository;
        this.trunkArtilleryRepository = trunkArtilleryRepository;
        this.tankRepository = tankRepository;
    }

    private void initRoles() {
        if (roleRepository.count() == 0) {
            RoleEntity adminRole = new RoleEntity().setName(AccountRole.ADMINISTRATOR);
            RoleEntity moderatorRole = new RoleEntity().setName(AccountRole.MODERATOR);
            RoleEntity userRole = new RoleEntity().setName(AccountRole.USER);

            roleRepository.save(adminRole);
            roleRepository.save(moderatorRole);
            roleRepository.save(userRole);
        }
    }

    public UserEntity createTestAdmin(String username) {

        initRoles();

        var admin = new UserEntity()
                .setEmail("admin@test.com")
                .setUsername(username)
                .setUserType(UserType.PERSON)
                .setActive(true)
                .setPassword("12345")
                .setFullName("Admin Adminov")
                .setDeposit(BigDecimal.valueOf(10000))
                .setRoles(roleRepository.findAll());

        return testUserRepository.save(admin);
    }

    public UserEntity createTestUser(String username) {

        initRoles();

        var user = new UserEntity()
                .setEmail("user@test.com")
                .setUsername(username)
                .setUserType(UserType.PERSON)
                .setActive(true)
                .setPassword("12345")
                .setFullName("User Userov")
                .setDeposit(BigDecimal.valueOf(10000))
                .setRoles(roleRepository.findAll()
                        .stream().filter(r -> r.getName() != AccountRole.ADMINISTRATOR && r.getName() != AccountRole.MODERATOR)
                        .collect(Collectors.toList()));


        return testUserRepository.save(user);
    }

    public PistolEntity createTestPistol() {
        PistolEntity testPistol = (PistolEntity) new PistolEntity()
                .setName("Test pistol")
                .setCountryOfOrigin("Test country")
                .setEnteredService(1990)
                .setCaliber(9.0)
                .setPrice(BigDecimal.valueOf(100))
                .setImageUrl("http://test-link-img.jpg");
        return pistolRepository.save(testPistol);
    }

    public MachineGunEntity createTestMachineGun() {
        MachineGunEntity testMachineGun = (MachineGunEntity) new MachineGunEntity()
                .setName("Test machine gun")
                .setCountryOfOrigin("Test country")
                .setEnteredService(1990)
                .setCaliber(7.62)
                .setPrice(BigDecimal.valueOf(100))
                .setImageUrl("http://test-link-img.jpg");
        return machineGunRepository.save(testMachineGun);
    }

    public void cleanDatabase() {
        testUserRepository.deleteAll();
        pistolRepository.deleteAll();
        machineGunRepository.deleteAll();
    }
}
