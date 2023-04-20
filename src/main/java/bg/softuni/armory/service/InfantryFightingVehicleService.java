package bg.softuni.armory.service;

import bg.softuni.armory.model.entity.IFV.InfantryFightingVehicleEntity;
import bg.softuni.armory.model.entity.dto.IfvAddDTO;
import bg.softuni.armory.model.entity.user.UserEntity;
import bg.softuni.armory.model.entity.views.InfantryFightingVehicleViewDTO;
import bg.softuni.armory.model.entity.views.WeaponPictureAndNameViewDTO;
import bg.softuni.armory.model.enums.AccountRole;
import bg.softuni.armory.model.enums.UserType;
import bg.softuni.armory.model.exception.NotAllowedToBuyException;
import bg.softuni.armory.repository.InfantryFightingVehicleRepository;
import bg.softuni.armory.repository.RoleRepository;
import bg.softuni.armory.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class InfantryFightingVehicleService {
    private final InfantryFightingVehicleRepository infantryFightingVehicleRepository;
    private final ModelMapper modelMapper;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public InfantryFightingVehicleService(InfantryFightingVehicleRepository infantryFightingVehicleRepository, ModelMapper modelMapper, UserRepository userRepository, RoleRepository roleRepository) {
        this.infantryFightingVehicleRepository = infantryFightingVehicleRepository;
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    public void seedIFV() {
        if (infantryFightingVehicleRepository.count() > 0) {
            return;
        }

        List<InfantryFightingVehicleEntity> vehicles = new ArrayList<>();

        InfantryFightingVehicleEntity bmp1 = new InfantryFightingVehicleEntity()
                .setName("BMP-1")
                .setCountryOfOrigin("Soviet Union")
                .setEnteredService(1966)
                .setCrew(3)
                .setPersonnel(8)
                .setMainGun("73mm 2A28")
                .setATGW("9M14 \"Malyutka\"")
                .setWeight(13.2)
                .setLength(6.735)
                .setWidth(2.94)
                .setHeight(2.068)
                .setMainGunCaliber(73)
                .setMachineGun("7.62 mm PKT")
                .setMainGunAmmoLoad(40)
                .setMachineGunAmmoLoad(2000)
                .setEngine("UTD-20, 6-cylinder 4-stroke V-shaped airless-injection water-cooled multifuel 15.8 liter diesel\n" +
                        "300 hp (224 kW) at 2,600 rpm")
                .setMaxSpeed(65)
                .setMaxRange(600)
                .setPrice(BigDecimal.valueOf(1000000))
                .setImageUrl("http://www.military-today.com/apc/bmp1.jpg")
                .setDescription("The BMP-1 is a Soviet amphibious tracked infantry fighting vehicle, in service 1966–present. BMP stands for Boyevaya Mashina Pyekhoty 1 (Russian: Боевая Машина Пехоты 1; БМП-1), meaning \"infantry fighting vehicle, 1st serial model\". The BMP-1 was the first mass-produced infantry fighting vehicle (IFV) of the Soviet Union.");
        vehicles.add(bmp1);

        InfantryFightingVehicleEntity bmpt = new InfantryFightingVehicleEntity()
                .setName("BMPT-Terminator")
                .setCountryOfOrigin("Russia")
                .setEnteredService(2011)
                .setCrew(5)
                .setPersonnel(0)
                .setMainGun("2 x 30mm 2A42")
                .setATGW("4× 130 mm Ataka-T GWS launchers")
                .setWeight(48.0)
                .setLength(7.200)
                .setWidth(3.37)
                .setHeight(1.94)
                .setMainGunCaliber(30)
                .setMachineGun("7.62 mm PKT")
                .setMainGunAmmoLoad(900)
                .setMachineGunAmmoLoad(2000)
                .setEngine("V-92S2 diesel engine " +
                        "1,000 hp (736 kW)")
                .setMaxSpeed(65)
                .setMaxRange(550)
                .setPrice(BigDecimal.valueOf(1800000))
                .setImageUrl("https://img1.cgtrader.com/items/2742436/7a735754dd/large/bmpt-terminator-3d-model-max-obj-fbx.jpg")
                .setDescription("The BMPT \"Terminator\" (Боевая машина поддержки танков - Tank Support Fighting Vehicle) is an armored fighting vehicle (AFV), designed and manufactured by the Russian company Uralvagonzavod. This vehicle was designed for supporting tanks and other AFVs in urban areas. The BMPT is unofficially named the \"Terminator\" by the manufacturers. It is heavily armed and armored to survive in urban combat. The AFV is armed with four 9M120 Ataka missile launchers, two 30 mm 2A42 autocannons, two AG-17D grenade launchers, and one coaxial 7.62 mm PKTM machine gun.");
        vehicles.add(bmpt);

        InfantryFightingVehicleEntity m2bradley = new InfantryFightingVehicleEntity()
                .setName("M2 Bradley")
                .setCountryOfOrigin("United States")
                .setEnteredService(1981)
                .setCrew(3)
                .setPersonnel(8)
                .setMainGun("25 mm M242 chain gun")
                .setATGW("2 × TOW anti-tank missile launchers (7 missiles)")
                .setWeight(27.6)
                .setLength(6.55)
                .setWidth(3.60)
                .setHeight(2.98)
                .setMainGunCaliber(25)
                .setMachineGun("7.62 mm coaxial M240C machine gun")
                .setMainGunAmmoLoad(900)
                .setMachineGunAmmoLoad(2200)
                .setEngine("VTA-903T 8-cylinder diesel\n" +
                        "600 hp")
                .setMaxSpeed(64)
                .setMaxRange(480)
                .setPrice(BigDecimal.valueOf(5500000))
                .setImageUrl("https://i.ytimg.com/vi/cdADxVKPsgs/maxresdefault.jpg")
                .setDescription("The Bradley is designed for reconnaissance and to transport a squad of infantry, providing them protection from small arms fire, while providing firepower to both suppress and eliminate most threats to friendly infantry. It is designed to be highly maneuverable and to be fast enough to keep up with heavy armor during an advance. The M2 holds a crew of three: a commander, a gunner, and a driver, as well as six fully equipped soldiers as passengers.");
        vehicles.add(m2bradley);

        InfantryFightingVehicleEntity zbd04 = new InfantryFightingVehicleEntity()
                .setName("ZBD-04")
                .setCountryOfOrigin("China")
                .setEnteredService(1999)
                .setCrew(3)
                .setPersonnel(7)
                .setMainGun("100 mm rifled gun")
                .setATGW("4 x HJ-8 anti-tank missiles")
                .setWeight(24.0)
                .setLength(7.20)
                .setWidth(3.20)
                .setHeight(2.50)
                .setMainGunCaliber(100)
                .setMachineGun("7.62 mm coaxial machine gun")
                .setMainGunAmmoLoad(30)
                .setMachineGunAmmoLoad(2200)
                .setEngine("ZBD-04: Type 6V150 diesel 440 kilowatts (590 hp)")
                .setMaxSpeed(65)
                .setMaxRange(500)
                .setPrice(BigDecimal.valueOf(1350000))
                .setImageUrl("https://www.army-technology.com/wp-content/uploads/sites/3/2019/10/2l-Image-ZBD-04A-Tracked-IFV.jpg")
                .setDescription("The ZBD-04 or Type 04 (industrial designation WZ502) is a Chinese infantry fighting vehicle. It bears some external resemblance to the BMP-3, particularly with regards to its turret and main armament; However, the chassis and internal subsystem possesses a different layout. The earliest prototypes received the designation ZBD-97. An improved version, ZBD-04A, is the vehicle currently in service and being produced.");
        vehicles.add(zbd04);

        infantryFightingVehicleRepository.saveAll(vehicles);
    }

    public List<WeaponPictureAndNameViewDTO> getAllIFVs() {
        return infantryFightingVehicleRepository
                .findAll()
                .stream()
                .map(ifv -> modelMapper.map(ifv, WeaponPictureAndNameViewDTO.class))
                .collect(Collectors.toList());
    }

    public InfantryFightingVehicleViewDTO getIFVDetails(Long id) {
        InfantryFightingVehicleEntity vehicle = infantryFightingVehicleRepository.findById(id).get();
        return modelMapper.map(vehicle, InfantryFightingVehicleViewDTO.class);
    }

    public void buyIFV(Long ifvId, UserDetails userDetails) throws NotAllowedToBuyException {
        UserEntity user = userRepository.findUserEntityByUsername(userDetails.getUsername()).orElseThrow();
        if (!user.isActive()) {
            throw new NotAllowedToBuyException("Inactive user!");
        }
        if (user.getUserType().equals(UserType.PERSON) && !user.getRoles().contains(roleRepository.findByName(AccountRole.ADMINISTRATOR))) {
            throw new NotAllowedToBuyException("This weapon is not allowed to be bought by a person!");
        }
        InfantryFightingVehicleEntity vehicle = infantryFightingVehicleRepository.findById(ifvId).orElseThrow();

        if (user.getDeposit().compareTo(vehicle.getPrice()) < 0) {
            throw new NotAllowedToBuyException("You don't have enough money!");
        }

        user.getBoughtIfvs().add(vehicle);
        vehicle.getUsers().add(user);

        BigDecimal fundsLeft = user.getDeposit().subtract(vehicle.getPrice());
        user.setDeposit(fundsLeft);
        userRepository.save(user);
        infantryFightingVehicleRepository.save(vehicle);
    }

    public void addIfv(IfvAddDTO ifvAddDTO) {
       InfantryFightingVehicleEntity vehicle = modelMapper.map(ifvAddDTO, InfantryFightingVehicleEntity.class);
       infantryFightingVehicleRepository.save(vehicle);
    }
}
