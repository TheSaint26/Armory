package bg.softuni.armory.service;

import bg.softuni.armory.model.entity.dto.FirearmAddDTO;
import bg.softuni.armory.model.entity.firearms.AssaultRifleEntity;
import bg.softuni.armory.model.entity.firearms.GrenadeLauncherEntity;
import bg.softuni.armory.model.entity.firearms.SniperEntity;
import bg.softuni.armory.model.entity.user.UserEntity;
import bg.softuni.armory.model.entity.views.FirearmViewDTO;
import bg.softuni.armory.model.entity.views.WeaponPictureAndNameViewDTO;
import bg.softuni.armory.model.enums.FireArmType;
import bg.softuni.armory.repository.GrenadeLauncherRepository;
import bg.softuni.armory.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GrenadeLauncherService {
    private final GrenadeLauncherRepository grenadeLauncherRepository;
    private final ModelMapper modelMapper;
    private final UserRepository userRepository;

    public GrenadeLauncherService(GrenadeLauncherRepository grenadeLauncherRepository, ModelMapper modelMapper, UserRepository userRepository) {
        this.grenadeLauncherRepository = grenadeLauncherRepository;
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
    }

    public void seedGrenadeLaunchers() {
        if (grenadeLauncherRepository.count() > 0) {
            return;
        }

        List<GrenadeLauncherEntity> grenadeLaunchers = new ArrayList<>();

        GrenadeLauncherEntity rpg7 = (GrenadeLauncherEntity) new GrenadeLauncherEntity()
                .setName("RPG-7")
                .setCountryOfOrigin("Soviet Union")
                .setEnteredService(1961)
                .setCaliber(40.0)
                .setWeight(6.30)
                .setLength(950.0)
                .setMuzzleVelocity(115)
                .setPracticalRateOfFire(6)
                .setSightingRange(700)
                .setEffectiveFire(300)
                .setPrice(BigDecimal.valueOf(2500))
                .setImageUrl("https://media.sketchfab.com/models/72041eed894f4028a7fbbeb6347390d9/thumbnails/2cc42ae112c74283a7ea08226235436d/f1bf003ebd3e405a903c153733e7035b.jpeg")
                .setDescription("RPG-7G is a portable, unguided, shoulder-launched, anti-tank rocket-propelled grenade launcher. is one of the most widely spread and popular weapon in the world. Its purpose is to destroy opponent's heavily armored tanks, light armored vehicles, fire points and troops.");

        grenadeLaunchers.add(rpg7);

        GrenadeLauncherEntity rpg30 = (GrenadeLauncherEntity) new GrenadeLauncherEntity()
                .setName("RPG-30")
                .setCountryOfOrigin("Russia")
                .setEnteredService(2012)
                .setCaliber(105.0)
                .setWeight(10.3)
                .setLength(1150.0)
                .setMuzzleVelocity(120)
                .setPracticalRateOfFire(4)
                .setSightingRange(700)
                .setEffectiveFire(350)
                .setPrice(BigDecimal.valueOf(3000))
                .setImageUrl("https://soldat.pro/wp-content/uploads/2018/07/b791ab6acd6a0d490cc290a243fe673c.jpg")
                .setDescription("The RPG-30 is a Russian anti-tank rocket launcher. Sometimes this weapon is nicknamed the \"Kryuk\" (hook). It was developed from the RPG-27. This weapon was specially designed to overcome active (also called as hard-kill) protection systems, such as Trophy, that become increasingly popular on main battle tanks. This rocket launcher was unveiled in 2008. The RPG-30 was reportedly adopted by the Russian Army in 2012. Deliveries commenced in 2013. This weapon is used by the Russian Army. Though it seems that production numbers of the RPG-30 were rather small. In 2022 this weapon was used by the Russian Army in Ukraine. Eventually some RPG-30s were captured by Ukrainians and were used against their former owners.");
        grenadeLaunchers.add(rpg30);

        GrenadeLauncherEntity javelin = (GrenadeLauncherEntity) new GrenadeLauncherEntity()
                .setName("FGM-148 Javelin")
                .setCountryOfOrigin("United States")
                .setEnteredService(1996)
                .setCaliber(127.0)
                .setWeight(22.3)
                .setLength(1100.0)
                .setMuzzleVelocity(140)
                .setPracticalRateOfFire(4)
                .setSightingRange(800)
                .setEffectiveFire(350)
                .setPrice(BigDecimal.valueOf(4000))
                .setImageUrl("https://360view.hum3d.com/standard/Weapons_2/FGM-148_Javelin_360_720_50-6.jpg")
                .setDescription("The FGM-148 Javelin, or Advanced Anti-Tank Weapon System-Medium (AAWS-M), is an American-made portable man-portable anti-tank systems system in service since 1996, and continuously upgraded. It replaced the M47 Dragon anti-tank missile in US service. Its fire-and-forget design uses automatic infrared guidance that allows the user to seek cover immediately after launch, in contrast to wire-guided systems, like the system used by the Dragon, which require a user to guide the weapon throughout the engagement. The Javelin's high-explosive anti-tank (HEAT) warhead can defeat modern tanks by top attack, hitting them from above, where their armor is thinnest, and is also useful against fortifications in a direct attack flight.\n" +
                        "\n" +
                        "As of 2019, according to claims by the manufacturer, the Javelin had been used in around 5,000 successful engagements.");
        grenadeLaunchers.add(javelin);

        grenadeLauncherRepository.saveAll(grenadeLaunchers);
    }

    public List<WeaponPictureAndNameViewDTO> getGrenadeLaunchers() {
        return grenadeLauncherRepository
                .findAll()
                .stream()
                .map(gl -> modelMapper.map(gl, WeaponPictureAndNameViewDTO.class))
                .collect(Collectors.toList());
    }

    public FirearmViewDTO getGrenadeLauncherDetails(Long id) {
        GrenadeLauncherEntity grenadeLauncher = grenadeLauncherRepository.findById(id).get();
        return modelMapper.map(grenadeLauncher, FirearmViewDTO.class);
    }
    public void buyGrenadeLauncher(Long grenadeLauncherId, UserDetails userDetails) {
        UserEntity user = userRepository.findUserByEmail(userDetails.getUsername()).orElseThrow();
        GrenadeLauncherEntity grenadeLauncher = grenadeLauncherRepository.findById(grenadeLauncherId).get();
        user.getBoughtGrenadeLaunchers().add(grenadeLauncher);
        userRepository.save(user);
    }

    public void addGrenadelauncher(FirearmAddDTO firearmAddDTO) {
        GrenadeLauncherEntity grenadeLauncher = modelMapper.map(firearmAddDTO, GrenadeLauncherEntity.class);
        grenadeLauncher.setType(FireArmType.GRENADE_LAUNCHER);
        grenadeLauncherRepository.save(grenadeLauncher);
    }
}
