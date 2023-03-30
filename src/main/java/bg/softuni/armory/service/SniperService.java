package bg.softuni.armory.service;

import bg.softuni.armory.model.entity.firearms.GrenadeLauncherEntity;
import bg.softuni.armory.model.entity.firearms.SniperEntity;
import bg.softuni.armory.model.entity.user.UserEntity;
import bg.softuni.armory.model.entity.views.FirearmViewDTO;
import bg.softuni.armory.model.entity.views.WeaponPictureAndNameViewDTO;
import bg.softuni.armory.repository.SniperRepository;
import bg.softuni.armory.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SniperService {
    private final SniperRepository sniperRepository;
    private final ModelMapper modelMapper;
    private final UserRepository userRepository;

    public SniperService(SniperRepository sniperRepository, ModelMapper modelMapper, UserRepository userRepository) {
        this.sniperRepository = sniperRepository;
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
    }

    public void seedSnipers() {
        if (sniperRepository.count() > 0) {
            return;
        }

        List<SniperEntity> snipers = new ArrayList<>();

        SniperEntity svd = (SniperEntity) new SniperEntity()
                .setName("Dragunov")
                .setCountryOfOrigin("Soviet Union")
                .setEnteredService(1963)
                .setCaliber(7.62)
                .setWeight(4.30)
                .setLength(1225.0)
                .setBarrelLength(620.0)
                .setMuzzleVelocity(830)
                .setCyclicRateOfFire(55)
                .setPracticalRateOfFire(30)
                .setMagazineCapacity(10)
                .setSightingRange(1200)
                .setEffectiveFire(800)
                .setPrice(BigDecimal.valueOf(3530))
                .setImageUrl("https://special-ops.org/wp-content/uploads/2016/02/svd-dragunov.jpg")
                .setDescription("The SVD (Russian: Снайперская Винтовка системы Драгунова образца 1963 года, romanized: Snayperskaya Vintovka sistem'y Dragunova obraz'tsa 1963 goda, lit. 'Sniper Rifle, System of Dragunov, Model of the Year 1963'), GRAU index 6V1, is a semi-automatic marksman rifle chambered in the fully-powered 7.62×54mmR cartridge, developed in the Soviet Union. The SVD was designed to serve a squad support role to provide precise long-range engagement capabilities to ordinary troops following the Warsaw Pact adoption of the 7.62×39mm intermediate cartridge and assault rifles as standard infantry weapon systems. At the time, NATO used battle rifles chambered in 7.62×51mm NATO as standard infantry weapon systems and had not yet adopted an intermediate cartridge and assault rifle of their own, allowing them to outrange their Warsaw Pact counterparts.\n" +
                        "\n" +
                        "It was developed through 1958–1963 and selected as the winner of a contest that included three competing groups of designers, led by Sergei Simonov (prototype rejected in April 1960), Aleksandr Konstantinov, and Yevgeny Dragunov. Extensive field testing of the rifles conducted in a wide range of environmental conditions (Konstantinov's competing 2B-W-10 prototype was simpler and cheaper but tested less accurate, durable and reliable) resulted in Dragunov's proposal being accepted into service in July 1963. An initial pre-production batch consisting of 200 rifles was assembled for evaluation purposes, and from 1964 serial production was carried out by Izhmash, later called Kalashnikov Concern.\n" +
                        "\n" +
                        "Since then, the SVD has become the standard squad support weapon of several countries, including those of the former Warsaw Pact. China produced a copy of the SVD through reverse-engineered samples captured during the Sino-Vietnamese War as the Type 79 and 85. Iran also produced a clone, the Nakhjir 3, which was a direct copy of the Chinese Type 79. ");
        snipers.add(svd);

        SniperEntity m24 = (SniperEntity) new SniperEntity()
                .setName("Remington M24 Sniper Weapon System")
                .setCountryOfOrigin("United States")
                .setEnteredService(1988)
                .setCaliber(7.62)
                .setWeight(5.40)
                .setLength(1092.0)
                .setBarrelLength(610.0)
                .setMuzzleVelocity(790)
                .setCyclicRateOfFire(55)
                .setPracticalRateOfFire(20)
                .setMagazineCapacity(5)
                .setSightingRange(1100)
                .setEffectiveFire(800)
                .setPrice(BigDecimal.valueOf(2999.99))
                .setImageUrl("https://www.americanrifleman.org/media/xv4pbu1l/sws1.jpg")
                .setDescription("The M24 Sniper Weapon System (SWS) or M24 is the military and police version of the Remington Model 700 rifle, M24 being the model name assigned by the United States Army after adoption as their standard sniper rifle in 1988. The M24 is referred to as a \"weapon system\" because it consists of not only a rifle, but also a detachable telescopic sight and other accessories.\n" +
                        "\n" +
                        "The M24 SWS has the \"long action\" bolt version of the Remington 700 receiver but is chambered for the 7.62×51mm NATO \"short action\" cartridge that has an overall length of 2.750 inches (69.85 mm). The \"long action\" allows the rifle to be re-configured for dimensionally larger cartridges up to 3.340 inches (84.84 mm) in overall length.\n" +
                        "\n" +
                        "The M24 originally came tapped for the Leupold Ultra M3A 10×42mm fixed-power scope, which came with a circle-shaped mil-dot glass-etched reticle. This was later replaced in 1998 by the Leupold Mk 4 LR/T M1 10×40mm fixed-power scope with an elongated-shaped mil-dot wire reticle. The rifle also comes with a detachable Harris 9–13\" 1A2-LM or Harris 9–13\" 1A2-L bipod unit.\n" +
                        "\n" +
                        "The M24 SWS was to be replaced with the M110 Semi-Automatic Sniper System, a contract awarded to Knight's Armament Company. However, the Army still continued to acquire M24s from Remington until February 2010 and upgraded to the A2 and M24E1 standard in many cases, continuing to serve. The Army chose to upgrade all its M24 rifles in the arsenals to the M2010 Enhanced Sniper Rifle, with the final M24 being converted in April 2014.");
        snipers.add(m24);

        sniperRepository.saveAll(snipers);
    }

    public List<WeaponPictureAndNameViewDTO> getAllSnipers() {
        return sniperRepository
                .findAll()
                .stream()
                .map(s -> modelMapper.map(s, WeaponPictureAndNameViewDTO.class))
                .collect(Collectors.toList());
    }

    public FirearmViewDTO getSniperDetails(Long id) {
        SniperEntity sniper = sniperRepository.findById(id).get();
        return modelMapper.map(sniper, FirearmViewDTO.class);
    }

    public void buySniper(Long sniperId, UserDetails userDetails) {
        UserEntity user = userRepository.findUserByEmail(userDetails.getUsername()).orElseThrow();
        SniperEntity sniper = sniperRepository.findById(sniperId).get();
        user.getBoughtSnipers().add(sniper);
        userRepository.save(user);
    }
}
