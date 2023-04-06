package bg.softuni.armory.service;

import bg.softuni.armory.model.entity.artillery.TrunkArtilleryEntity;
import bg.softuni.armory.model.entity.dto.TrunkArtilleryAddDTO;
import bg.softuni.armory.model.entity.user.UserEntity;
import bg.softuni.armory.model.entity.views.TrunkArtilleryViewDTO;
import bg.softuni.armory.model.entity.views.WeaponPictureAndNameViewDTO;
import bg.softuni.armory.model.enums.AccountRole;
import bg.softuni.armory.model.enums.TrunkArtilleryType;
import bg.softuni.armory.model.enums.UserType;
import bg.softuni.armory.model.exception.NotAllowedToBuyException;
import bg.softuni.armory.repository.RoleRepository;
import bg.softuni.armory.repository.TrunkArtilleryRepository;
import bg.softuni.armory.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TrunkArtilleryService {
    private final TrunkArtilleryRepository trunkArtilleryRepository;
    private final ModelMapper modelMapper;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public TrunkArtilleryService(TrunkArtilleryRepository trunkArtilleryRepository, ModelMapper modelMapper, UserRepository userRepository, RoleRepository roleRepository) {
        this.trunkArtilleryRepository = trunkArtilleryRepository;
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    public void seedTrunkArtillery() {
        if (trunkArtilleryRepository.count() > 0) {
            return;
        }
        List<TrunkArtilleryEntity> trunkArtilleryList = new ArrayList<>();

        TrunkArtilleryEntity giatsint = new TrunkArtilleryEntity()
                .setName("2S5 Giatsint")
                .setType(TrunkArtilleryType.SELF_PROPELLED)
                .setCountryOfOrigin("Soviet Union")
                .setEnteredService(1976)
                .setCrew(6)
                .setMachineGunCaliber(7.62)
                .setProjectileWeight(46.0)
                .setMaxFiringRange(33)
                .setMaxRateOfFire(6)
                .setHasMachineGun(true)
                .setMainGunCaliber(152)
                .setWeight(28.2)
                .setFullLength(8.95)
                .setHullLength(7.0)
                .setEngine("V-59 diesel")
                .setPrice(BigDecimal.valueOf(1800000))
                .setImageUrl("https://www.enemyforces.net/artillery/giatsint.jpg")
                .setDescription("The 2S5 Giatsint was intended to be used against important enemy targets. This artillery system was more capable than the 2S3 Akatsiya 152 mm self-propelled howitzer. It had a significantly longer range of fire as well as higher rate of fire. Furthermore it was capable of firing nuclear shells.");
        trunkArtilleryList.add(giatsint);

        TrunkArtilleryEntity gvozdika = new TrunkArtilleryEntity()
                .setName("2S1 Gvosdika")
                .setType(TrunkArtilleryType.SELF_PROPELLED)
                .setCountryOfOrigin("Soviet Union")
                .setEnteredService(1971)
                .setCrew(4)
                .setMachineGunCaliber(7.62)
                .setProjectileWeight(21.76)
                .setMaxFiringRange(15)
                .setMaxRateOfFire(5)
                .setHasMachineGun(true)
                .setMainGunCaliber(122)
                .setWeight(15.7)
                .setFullLength(7.26)
                .setHullLength(6.75)
                .setEngine("YaMZ-238V diesel 240hp")
                .setPrice(BigDecimal.valueOf(1500000))
                .setImageUrl("https://www.tanks-encyclopedia.com/coldwar/ussr/2S1_Gvozdika/2s1_Gvozdika-russia1.png")
                .setDescription("The 2S1 Gvosdika is fitted with a D-32 122 mm rifled howitzer. It is a modified variant of the D-30 towed howitzer. It is fitted with a load assisting system. Maximum rate of fire is 4-5 shells per minute. The Gvosdika is compatible with all 122 mm munitions developed for the D-30 howitzer. These include fragmentation, HE-FRAG, HEAT, cluster, smoke and illumination shells. A total of 40 shells are carried, usually 35 HE-FRAG and 5 HEAT. Maximum range of fire with HE-FRAG shell is 15.2 km. By modern standards such range is rather limited, but back in the late 1960s and 1970s it matched range of contemporary artillery systems.");
        trunkArtilleryList.add(gvozdika);

        TrunkArtilleryEntity m107 = new TrunkArtilleryEntity()
                .setName("M107")
                .setType(TrunkArtilleryType.SELF_PROPELLED)
                .setCountryOfOrigin("United States")
                .setEnteredService(1962)
                .setCrew(8)
                .setMachineGunCaliber(null)
                .setProjectileWeight(79.0)
                .setMaxFiringRange(40)
                .setMaxRateOfFire(1)
                .setHasMachineGun(false)
                .setMainGunCaliber(175)
                .setWeight(28.2)
                .setFullLength(11.25)
                .setHullLength(3.45)
                .setEngine("General Motors 8V71T diesel 345hp")
                .setPrice(BigDecimal.valueOf(1750000))
                .setImageUrl("https://360view.hum3d.com/zoom/Tanks/M107_self_propelled_gun_1000x1000_0001.jpg")
                .setDescription("During the formulation of the requirements that spawned the M107's development, a towed 175 mm gun was also considered by the US Army, but the mobility offered by a self-propelled 175 mm gun was deemed far more important for running artillery missions in Central Europe. Though in an ironic twist of fate, the Soviet Union developed and fielded equivalents to both a towed and self-propelled 175 mm gun - the 180 mm S-23 and 203 mm 2S7 Pion, respectively. Production of the M107 SPG began in 1962, and continued until 1980, with a total of 524 units built.");
        trunkArtilleryList.add(m107);

        TrunkArtilleryEntity m110 = new TrunkArtilleryEntity()
                .setName("M110")
                .setType(TrunkArtilleryType.SELF_PROPELLED)
                .setCountryOfOrigin("United States")
                .setEnteredService(1961)
                .setCrew(5)
                .setMachineGunCaliber(null)
                .setProjectileWeight(92.53)
                .setMaxFiringRange(29)
                .setMaxRateOfFire(1)
                .setHasMachineGun(false)
                .setMainGunCaliber(203)
                .setWeight(28.35)
                .setFullLength(10.73)
                .setHullLength(5.72)
                .setEngine("General Motors 8V71T diesel 405hp")
                .setPrice(BigDecimal.valueOf(3000000))
                .setImageUrl("http://www.military-today.com/artillery/m110.jpg")
                .setDescription("The M110 is fitted with the M2A2 203 mm/L25 howitzer. This howitzer was developed from the British 8 inch howitzer, used during World War I. The M110 is fitted with load assisting system to reduce crew workload. It fires HE-FRAG and nuclear projectiles. Maximum range with the standard HE-FRAG projectile is 17 km. Maximum rate of fire is only one round per minute. Sustained rate of fire is one round every two minutes. The M110 carries only 2 rounds. Ammunition is carried by escorting armored personnel carrier.");
        trunkArtilleryList.add(m110);

//        TrunkArtilleryEntity sh3 = new TrunkArtilleryEntity()
//                .setName("SH-3")
//                .setType(TrunkArtilleryType.SELF_PROPELLED)
//                .setCountryOfOrigin("China")
//                .setEnteredService(2007)
//                .setCrew(5)
//                .setMachineGunCaliber(12.7)
//                .setProjectileWeight(22.0)
//                .setMaxFiringRange(27)
//                .setMaxRateOfFire(8)
//                .setHasMachineGun(true)
//                .setMainGunCaliber(122)
//                .setWeight(24.5)
//                .setFullLength(6.6)
//                .setHullLength(5.93)
//                .setEngine("BF8M1015CP diesel 590hp")
//                .setPrice(BigDecimal.valueOf(2100000))
//                .setImageUrl("https://www.armyrecognition.com/images/stories/asia/china/artillery_vehicle/wmz322_sh-3/WMZ322_SH-3_122mm_tracked_self-propelled_howitzer_China_Chinese_army_defense_industry_Internet_rear_view_001.jpg")
//                .setDescription("The SH-3 artillery system is an improved version of the Type 89. Its industrial designation is WMZ322. This artillery system was offered for export customers. The SH-3 can be seen as a China's newly-built equivalent to the Soviet 2S1 Gvosdika. It offers greater mobility, improved fire control system and delivers greater firepower than the 2S1 or the Type 89 self-propelled howitzers. The only known customer of the SH-3 is Rwanda. This country acquired 6 units in 2007. A modified version of the SH-3, the PLZ-07, was adopted by the China's army in the late 2000s and is being fielded in large numbers.");
//        trunkArtilleryList.add(sh3);

        trunkArtilleryRepository.saveAll(trunkArtilleryList);
    }

    public List<WeaponPictureAndNameViewDTO> getAllTrunkArtillery() {
        return trunkArtilleryRepository
                .findAll()
                .stream()
                .map(ta -> modelMapper.map(ta, WeaponPictureAndNameViewDTO.class))
                .collect(Collectors.toList());

    }

    public TrunkArtilleryViewDTO getTrunkArtilleryDetails(Long id) {
        TrunkArtilleryEntity trunkArtillery = trunkArtilleryRepository.findById(id).get();
        TrunkArtilleryViewDTO viewDTO = modelMapper.map(trunkArtillery, TrunkArtilleryViewDTO.class);
        viewDTO.setType(typeArtilleryToString(trunkArtillery.getType()));
        return viewDTO;
    }

    private String typeArtilleryToString(TrunkArtilleryType type) {
        switch (type) {
            case FIELD -> {
                return "Field";
            }
            case SELF_PROPELLED -> {
                return "Self Propelled";
            }
        }
        return null;
    }

    public void buyTrunkArtillery(Long trunkArtilleryId, UserDetails userDetails) throws NotAllowedToBuyException {
        UserEntity user = userRepository.findUserByEmail(userDetails.getUsername()).orElseThrow();
        if ((user.getUserType().equals(UserType.PERSON) || user.getUserType().equals(UserType.PARAMILITARY_ORGANIZATION)) && !user.getRoles().contains(roleRepository.findByName(AccountRole.ADMINISTRATOR))) {
            throw new NotAllowedToBuyException("This weapon is not allowed to be bought by a person or paramilitary organization!");
        }
        TrunkArtilleryEntity trunkArtillery = trunkArtilleryRepository.findById(trunkArtilleryId).orElseThrow();
        user.getBoughtTrunkArtillery().add(trunkArtillery);
        userRepository.save(user);
    }

    public void addTrunkArtillery(TrunkArtilleryAddDTO trunkArtilleryAddDTO) {
        TrunkArtilleryEntity trunkArtillery = modelMapper.map(trunkArtilleryAddDTO, TrunkArtilleryEntity.class);
        trunkArtilleryRepository.save(trunkArtillery);
    }
}
