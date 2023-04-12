package bg.softuni.armory.service;

import bg.softuni.armory.model.entity.dto.FirearmAddDTO;
import bg.softuni.armory.model.entity.firearms.PistolEntity;
import bg.softuni.armory.model.entity.user.UserEntity;
import bg.softuni.armory.model.entity.views.FirearmViewDTO;
import bg.softuni.armory.model.entity.views.WeaponPictureAndNameViewDTO;
import bg.softuni.armory.model.enums.FireArmType;
import bg.softuni.armory.model.exception.NotAllowedToBuyException;
import bg.softuni.armory.repository.PistolRepository;
import bg.softuni.armory.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PistolService {
    private final PistolRepository pistolRepository;
    private final ModelMapper modelMapper;
    private final UserRepository userRepository;

    public PistolService(PistolRepository pistolRepository, ModelMapper modelMapper, UserRepository userRepository) {
        this.pistolRepository = pistolRepository;
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
    }

    public void seedPistols() {
        if (pistolRepository.count() > 0) {
            return;
        }
        List<PistolEntity> pistols = new ArrayList<>();
        PistolEntity makarov = (PistolEntity) new PistolEntity()
                .setName("Makarov")
                .setCountryOfOrigin("Soviet Union")
                .setEnteredService(1951)
                .setCaliber(9.0)
                .setWeight(0.73)
                .setLength(161.5)
                .setBarrelLength(93.5)
                .setMuzzleVelocity(315)
                .setCyclicRateOfFire(90)
                .setPracticalRateOfFire(30)
                .setMagazineCapacity(8)
                .setSightingRange(25)
                .setEffectiveFire(50)
                .setPrice(BigDecimal.valueOf(100))
                .setImageUrl("https://upload.wikimedia.org/wikipedia/commons/thumb/6/6f/Makarov_%2828034065%29.jpeg/1200px-Makarov_%2828034065%29.jpeg")
                .setDescription("The Makarov pistol or PM (Russian: Пистоле́т Мака́рова, tr. Pistolét Makárova, IPA: [pʲɪstɐˈlʲet mɐˈkarəvə], lit. 'Makarov's Pistol') is a Soviet semi-automatic pistol. Under the project leadership of Nikolay Fyodorovich Makarov, it became the Soviet Union's standard military and Militsiya side arm in 1951.");
        pistols.add(makarov);
        PistolEntity glock17 = (PistolEntity) new PistolEntity()
                .setName("Glock 17")
                .setCountryOfOrigin("Austria")
                .setEnteredService(1981)
                .setCaliber(9.0)
                .setWeight(0.91)
                .setLength(204.0)
                .setBarrelLength(114.0)
                .setMuzzleVelocity(360)
                .setCyclicRateOfFire(90)
                .setPracticalRateOfFire(50)
                .setMagazineCapacity(14)
                .setSightingRange(50)
                .setEffectiveFire(50)
                .setPrice(BigDecimal.valueOf(439.04))
                .setImageUrl("https://cdn.webshopapp.com/shops/309865/files/382179852/760x650x2/deco-glock-17.jpg")
                .setDescription("This pistol has a simple design with a minimum of parts. There are only 33 parts, including the magazine. This pistol can be disassembled within a minute using just a pin, or nail. Many of the parts are interchangeable between various Glock models. The Glock 17 is simple in operation and failures are rear.");
        pistols.add(glock17);
        PistolEntity steyrM = (PistolEntity) new PistolEntity()
                .setName("Steyr M")
                .setCountryOfOrigin("Austria")
                .setEnteredService(1999)
                .setCaliber(9.0)
                .setWeight(0.78)
                .setLength(180.0)
                .setBarrelLength(101.0)
                .setMuzzleVelocity(460)
                .setCyclicRateOfFire(90)
                .setPracticalRateOfFire(54)
                .setMagazineCapacity(15)
                .setSightingRange(50)
                .setEffectiveFire(50)
                .setPrice(BigDecimal.valueOf(575.0))
                .setImageUrl("https://www.thefirearmblog.com/blog/wp-content/uploads/2020/03/Steyr-M9-A1-Box-Open-660x312.jpg")
                .setDescription("This pistol has a metal reinforced polymer frame and one-piece milled steel slide. All metal parts have a special finish, that provides protection against corrosion and wear. The pistol can be even kept for prolonged periods in salt water.");
        pistols.add(steyrM);

        PistolEntity psm = (PistolEntity) new PistolEntity()
                .setName("PSM")
                .setCountryOfOrigin("Soviet Union")
                .setEnteredService(1973)
                .setCaliber(5.45)
                .setWeight(0.510)
                .setLength(155.0)
                .setBarrelLength(85.0)
                .setMuzzleVelocity(315)
                .setCyclicRateOfFire(90)
                .setPracticalRateOfFire(30)
                .setMagazineCapacity(8)
                .setSightingRange(25)
                .setEffectiveFire(25)
                .setPrice(BigDecimal.valueOf(5000))
                .setImageUrl("https://i.ytimg.com/vi/RVs-OQYucRo/maxresdefault.jpg")
                .setDescription("This pistol was issued to security officers, top ranking officials of military and law enforcement, as well as top ranking members of Communist party. It was mainly used for self-defense and special operations.");
        pistols.add(psm);

        PistolEntity tt = (PistolEntity) new PistolEntity()
                .setName("TT")
                .setCountryOfOrigin("Soviet Union")
                .setEnteredService(1933)
                .setCaliber(7.62)
                .setWeight(0.854)
                .setLength(195.0)
                .setBarrelLength(116.0)
                .setMuzzleVelocity(480)
                .setCyclicRateOfFire(90)
                .setPracticalRateOfFire(50)
                .setMagazineCapacity(8)
                .setSightingRange(25)
                .setEffectiveFire(50)
                .setPrice(BigDecimal.valueOf(799.99))
                .setImageUrl("https://i.redd.it/u65pn18vsio11.jpg")
                .setDescription("The TT is chambered for 7.62x25 mm ammunition. Originally this pistol was planned to be chambered for the hughely popular 7.63x25 mm Mauser round. However a slightly different caliber was deliberately selected in order to make the new ammunitions incompatible with Western weapons. In case of war captured ammunition stocks would be useless for the enemy. In fact the TT could use the Mauser 7.63x25 mm ammunition, but not vice versa.");
        pistols.add(tt);

        pistolRepository.saveAll(pistols);
    }

    public List<WeaponPictureAndNameViewDTO> getPistolsList() {
        return pistolRepository
                .findAll()
                .stream()
                .map(p -> modelMapper.map(p, WeaponPictureAndNameViewDTO.class))
                .collect(Collectors.toList());
    }

    public FirearmViewDTO getPistolDetails(Long id) {
        PistolEntity pistol = pistolRepository.findById(id).get();
        return modelMapper.map(pistol, FirearmViewDTO.class);
    }

    public void buyPistol(Long pistolId, UserDetails userDetails) throws NotAllowedToBuyException {
        UserEntity user = userRepository.findUserEntityByUsername(userDetails.getUsername()).orElseThrow();
        if (!user.isActive()) {
            throw new NotAllowedToBuyException("Inactive user!");
        }
        PistolEntity pistol = pistolRepository.findById(pistolId).get();

        user.getBoughtPistols().add(pistol);
        pistol.getUsers().add(user);

        BigDecimal fundsLeft = user.getDeposit().subtract(pistol.getPrice());
        user.setDeposit(fundsLeft);

        userRepository.save(user);
        pistolRepository.save(pistol);
    }

    public void addPistol(FirearmAddDTO firearmAddDTO) {
        PistolEntity pistol = modelMapper.map(firearmAddDTO, PistolEntity.class);
        pistol.setType(FireArmType.PISTOL);
        pistolRepository.save(pistol);
    }
}
