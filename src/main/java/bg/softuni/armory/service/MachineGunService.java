package bg.softuni.armory.service;

import bg.softuni.armory.model.ArmoryUserDetails;
import bg.softuni.armory.model.entity.dto.FirearmAddDTO;
import bg.softuni.armory.model.entity.firearms.AssaultRifleEntity;
import bg.softuni.armory.model.entity.firearms.MachineGunEntity;
import bg.softuni.armory.model.entity.user.UserEntity;
import bg.softuni.armory.model.entity.views.FirearmViewDTO;
import bg.softuni.armory.model.entity.views.WeaponPictureAndNameViewDTO;
import bg.softuni.armory.model.enums.FireArmType;
import bg.softuni.armory.model.exception.NotAllowedToBuyException;
import bg.softuni.armory.repository.MachineGunRepository;
import bg.softuni.armory.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MachineGunService {
    private final MachineGunRepository machineGunRepository;
    private final ModelMapper modelMapper;
    private final UserRepository userRepository;

    public MachineGunService(MachineGunRepository machineGunRepository, ModelMapper modelMapper, UserRepository userRepository) {
        this.machineGunRepository = machineGunRepository;
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
    }

    public void seedMachineGuns() {
        if (machineGunRepository.count() > 0) {
            return;
        }
        List<MachineGunEntity> machineGuns = new ArrayList<>();

        MachineGunEntity pk = (MachineGunEntity) new MachineGunEntity()
                .setName("PK")
                .setCountryOfOrigin("Soviet Union")
                .setEnteredService(1961)
                .setCaliber(7.62)
                .setWeight(9.0)
                .setLength(1203.0)
                .setBarrelLength(605.0)
                .setMuzzleVelocity(825)
                .setCyclicRateOfFire(600)
                .setPracticalRateOfFire(250)
                .setMagazineCapacity(200)
                .setSightingRange(800)
                .setEffectiveFire(350)
                .setPrice(BigDecimal.valueOf(2800))
                .setImageUrl("https://photo.weaponsystems.net/image/s-carousel/n-fa_mg_pk_v2.jpg/--/img/ws/fa_mg_pk_v2.jpg")
                .setDescription("The PK (Russian: Пулемёт Калашникова, transliterated as Pulemyot Kalashnikova, or \"Kalashnikov's machine gun\"), is a belt-fed general-purpose machine gun, chambered for the 7.62×54mmR rimmed cartridge.\n" +
                        "\n" +
                        "Designed in the Soviet Union and currently in production in Russia, the original PK machine gun was introduced in 1961 and the improved PKM variant was introduced in 1969. The PKM was designed to replace the SGM and RP-46 machine guns that were previously in Soviet service.\n" +
                        "\n" +
                        "The weapon remains in use as a front-line infantry and vehicle-mounted weapon with Russia's armed forces and has also been exported extensively and produced in several other countries under license. ");
        machineGuns.add(pk);

        MachineGunEntity kpv = (MachineGunEntity) new MachineGunEntity()
                .setName("KPV Machine Gun")
                .setCountryOfOrigin("Soviet Union")
                .setEnteredService(1944)
                .setCaliber(14.5)
                .setWeight(52.5)
                .setLength(1980.0)
                .setBarrelLength(1346.0)
                .setMuzzleVelocity(1005)
                .setCyclicRateOfFire(600)
                .setPracticalRateOfFire(80)
                .setMagazineCapacity(50)
                .setSightingRange(4000)
                .setEffectiveFire(3000)
                .setPrice(BigDecimal.valueOf(7000))
                .setImageUrl("https://photo.weaponsystems.net/image/s-carousel/n-otr_gun_kpv_o1.jpg/--/img/ws/otr_gun_kpv_o1.jpg")
                .setDescription("The KPV-14.5 heavy machine gun (KPV is an initialism for Krupnokaliberniy Pulemyot Vladimirova (large-caliber machine gun Vladimirov), in Russian as Крупнокалиберный Пулемёт Владимирова, or КПВ) is a Soviet designed 14.5×114mm-caliber heavy machine gun, which first entered service as an infantry weapon (designated PKP) in 1949. In the 1960s, the infantry version was taken out of production because it was too large and heavy. It was later redesigned for anti-aircraft use, because it showed excellent results as an AA gun, with a range of 3,000 meters horizontally and 2,000 meters vertically against low flying planes. It was used in the ZPU series of anti-aircraft guns. Its size and power also made it a useful light anti-armour weapon on the BTR series of vehicles and the BRDM-2 scout car.");
        machineGuns.add(kpv);

        MachineGunEntity m240 = (MachineGunEntity) new MachineGunEntity()
                .setName("M240")
                .setCountryOfOrigin("United States")
                .setEnteredService(1977)
                .setCaliber(7.62)
                .setWeight(12.5)
                .setLength(1260.0)
                .setBarrelLength(630.0)
                .setMuzzleVelocity(853)
                .setCyclicRateOfFire(850)
                .setPracticalRateOfFire(250)
                .setMagazineCapacity(200)
                .setSightingRange(1800)
                .setEffectiveFire(800)
                .setPrice(BigDecimal.valueOf(3200))
                .setImageUrl("https://upload.wikimedia.org/wikipedia/commons/thumb/9/97/FN_MAG_white_background.jpg/600px-FN_MAG_white_background.jpg")
                .setDescription("The M240 has been used by the United States Armed Forces since the late 1970s. It is used extensively by infantry, most often in rifle companies, as well as on ground vehicles, watercraft and aircraft. Though it is heavier than some comparable weapons, it is highly regarded for reliability and its standardization among NATO members is a major advantage.\n" +
                        "\n" +
                        "All variants are fed from disintegrating belts and are capable of firing most types of 7.62 mm (.30/.308 cal) NATO ammunition. M240 variants can be converted to use non-disintegrating belts. There are significant differences in weight and some features among some versions which restrict the interchangeability of parts. The M240s used by the U.S. military are currently manufactured by FN America, the American subsidiary of the Belgian company FN Herstal.");
        machineGuns.add(m240);

        MachineGunEntity m2 = (MachineGunEntity) new MachineGunEntity()
                .setName("M2 Browning")
                .setCountryOfOrigin("United States")
                .setEnteredService(1933)
                .setCaliber(12.7)
                .setWeight(38.0)
                .setLength(1654.0)
                .setBarrelLength(1429.0)
                .setMuzzleVelocity(890)
                .setCyclicRateOfFire(600)
                .setPracticalRateOfFire(80)
                .setMagazineCapacity(50)
                .setSightingRange(1800)
                .setEffectiveFire(1200)
                .setPrice(BigDecimal.valueOf(6300))
                .setImageUrl("https://upload.wikimedia.org/wikipedia/commons/thumb/6/60/M2_Browning_and_ammunition_boxes_%282%29.jpg/1280px-M2_Browning_and_ammunition_boxes_%282%29.jpg")
                .setDescription("The M2 machine gun or Browning .50 caliber machine gun (informally, \"Ma Deuce\") is a heavy machine gun that was designed near the end of World War I by John Browning. While similar to Browning's earlier M1919 Browning machine gun, which was chambered for the .30-06 cartridge, the M2 uses Browning's larger and more powerful .50 BMG (12.7 mm) cartridge. The design has had many designations; the official U.S. military designation for the current infantry type is Browning Machine Gun, Cal. .50, M2, HB, Flexible. It is effective against infantry, unarmored or lightly armored vehicles and boats, light fortifications, and low-flying aircraft.\n" +
                        "\n" +
                        "The gun has been used extensively as a vehicle weapon and for aircraft armament by the United States since the 1930s. It was heavily used during World War II, the Korean War, the Vietnam War, the Falklands War, the Soviet–Afghan War, the Gulf War, the Iraq War, and the War in Afghanistan. It is the primary heavy machine gun of NATO countries and has been used by many other countries as well. U.S. forces have used the M2 longer than any other firearm except the .45 ACP M1911 pistol, which was also designed by John Browning. ");
        machineGuns.add(m2);

        machineGunRepository.saveAll(machineGuns);
    }

    public List<WeaponPictureAndNameViewDTO> getAllMachineGuns() {
        return machineGunRepository
                .findAll()
                .stream()
                .map(mg -> modelMapper.map(mg, WeaponPictureAndNameViewDTO.class))
                .collect(Collectors.toList());
    }

    public FirearmViewDTO getMachineGunDetails(Long id) {
        MachineGunEntity machineGun = machineGunRepository.findById(id).get();
        return modelMapper.map(machineGun, FirearmViewDTO.class);
    }

    public void buyMachineGun(Long machineGunId, ArmoryUserDetails userDetails) throws NotAllowedToBuyException {
        UserEntity user = userRepository.findUserEntityByUsername(userDetails.getUsername()).orElseThrow();
        if (!user.isActive()) {
            throw new NotAllowedToBuyException("Inactive user!");
        }
        MachineGunEntity machineGun = machineGunRepository.findById(machineGunId).get();
        user.getBoughtMachineGuns().add(machineGun);
        machineGun.getUsers().add(user);

        BigDecimal fundsLeft = user.getDeposit().subtract(machineGun.getPrice());
        user.setDeposit(fundsLeft);

        userRepository.save(user);
        machineGunRepository.save(machineGun);
    }

    public void addMachineGun(FirearmAddDTO firearmAddDTO) {
        MachineGunEntity machineGun = modelMapper.map(firearmAddDTO, MachineGunEntity.class);
        machineGun.setType(FireArmType.MACHINE_GUN);
        machineGunRepository.save(machineGun);
    }
}
