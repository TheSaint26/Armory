package bg.softuni.armory.service;

import bg.softuni.armory.model.entity.dto.FirearmAddDTO;
import bg.softuni.armory.model.entity.firearms.AssaultRifleEntity;
import bg.softuni.armory.model.entity.firearms.PistolEntity;
import bg.softuni.armory.model.entity.user.UserEntity;
import bg.softuni.armory.model.entity.views.FirearmViewDTO;
import bg.softuni.armory.model.entity.views.WeaponPictureAndNameViewDTO;
import bg.softuni.armory.model.enums.FireArmType;
import bg.softuni.armory.model.exception.NotAllowedToBuyException;
import bg.softuni.armory.repository.AssaultRifleRepository;
import bg.softuni.armory.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AssaultRifleService {
    private final AssaultRifleRepository assaultRifleRepository;
    private final ModelMapper modelMapper;
    private final UserRepository userRepository;

    public AssaultRifleService(AssaultRifleRepository assaultRifleRepository, ModelMapper modelMapper, UserRepository userRepository) {
        this.assaultRifleRepository = assaultRifleRepository;
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
    }

    public void seedAssaultRifles() {
        if (assaultRifleRepository.count() > 0) {
            return;
        }

        List<AssaultRifleEntity> assaultRifles = new ArrayList<>();

        AssaultRifleEntity ak74 = (AssaultRifleEntity) new AssaultRifleEntity()
                .setName("AK74")
                .setCountryOfOrigin("Soviet Union")
                .setEnteredService(1974)
                .setCaliber(5.45)
                .setWeight(3.07)
                .setLength(943.0)
                .setBarrelLength(415.0)
                .setMuzzleVelocity(900)
                .setCyclicRateOfFire(600)
                .setPracticalRateOfFire(100)
                .setMagazineCapacity(30)
                .setSightingRange(1000)
                .setEffectiveFire(500)
                .setPrice(BigDecimal.valueOf(2000))
                .setImageUrl("https://www.forces.net/sites/default/files/AK-74_with_magazines.jpeg")
                .setDescription("he AK-74 has improved firing accuracy over the AKM. This weapon retains all advantages and disadvantages of Kalashnikov design, including reliability, ruggedness, simplicity of operation and maintenance. This weapon do not jams or misfires in worst conditions possible. Also it has reliable extraction even with dirty chamber and cases. This weapon can be field stripped in one minute without using any tools. Its design simplicity made it suitable for mass production. Its drawbacks are poor balance and ergonomics, as well as inferior firing accuracy to most Western weapons.\n" +
                        "\n" +
                        "   The AK-74 is a gas operated, selective fire weapon. Design of this weapon is similar to that of the previous AKM. Even 53% of the parts are interchangeable. Such compatibility allowed to reduce production costs, simplified logistics and training.\n" +
                        "\n" +
                        "   This weapon is chambered for the 5.45x39 mm small-caliber, high velocity round, that has a slim and relatively long bullet. The AK-74 is more accurate than the previous AKM due to improved ballistics and lower recoil. Also the soldier can carry more ammunition as it is lighter. However the 5.45x39 mm ammunition lacks penetration of the older 7.62x39 mm round. It is also inferior to the standard NATO 5.56x45 mm round. The AK-74 could not match accuracy of the original M16 and was even less accurate than a US M16A2, which was adopted in 1982.");
        assaultRifles.add(ak74);
        AssaultRifleEntity ak47 = (AssaultRifleEntity) new AssaultRifleEntity()
                .setName("AK47")
                .setCountryOfOrigin("Soviet Union")
                .setEnteredService(1949)
                .setCaliber(7.62)
                .setWeight(3.47)
                .setLength(880.0)
                .setBarrelLength(415.0)
                .setMuzzleVelocity(710)
                .setCyclicRateOfFire(600)
                .setPracticalRateOfFire(100)
                .setMagazineCapacity(30)
                .setSightingRange(800)
                .setEffectiveFire(500)
                .setPrice(BigDecimal.valueOf(1500))
                .setImageUrl("https://www.gannett-cdn.com/-mm-/be78476c693bb657af1d52250e4a6f97cc8400a0/c=0-21-2121-1219/local/-/media/2016/05/13/StCloud/StCloud/635987346799957171-AK47.jpg")
                .setDescription("In 1949 the improved AK-47 was adopted Soviet Army simply as Avtomat Kalashnikova (Kalashnikov's Assault Rifle), or AK. So official designation of this weapon was AK, rather than AK-47 as it is commonly known today. Number \"47\" in the designation indicates that it is \"Model 1947\". The AK-47 designation was began to be used when improved versions of this weapon, such as the AK-74 were introduced. So mass production of the AK-47 began in 1949. This design was so successful, that shortly it displaced every other firearm in the Soviet Army, except pistols, machine guns and sniper rifles. It was a standard-issue infantry weapon until 1959, when improved AKM assault rifle was introduced. Modern versions of the AK-47 are still standard-issue infantry rifles with the Russian military.\n" +
                        "\n" +
                        "   Contrary to most beliefs the original AK-47 assault rifle is no longer used. In most cases weapons that we see today are actually not the AK-47 but its newer and significantly improved versions. The names 'AK-47' and 'Kalashnikov' are often incorrectly applied to any Kalashnikov-derived rifle regardless of type or country of origin. Furthermore the original AK-47 with a stamped receiver was actually a failure in mass production. Still though the AK-47 made its name for its reliability, ruggedness, simplicity of operation and maintenance. After its introduction this assault rifle was constantly improved in order to simplify production and improve its capabilities. It took 10 years to develop and perfect a sheet metal fabrication for this weapon. Improved and late production AK-47 rifles have some minor differences. Production of the original AK-47 stopped in the Soviet Union in the late 1950s and this weapon is no longer used. Export operators also retired the original AK-47 in favor of its improved versions.");
        assaultRifles.add(ak47);

        AssaultRifleEntity m16 = (AssaultRifleEntity) new AssaultRifleEntity()
                .setName("M16")
                .setCountryOfOrigin("United States")
                .setEnteredService(1964)
                .setCaliber(5.56)
                .setWeight(3.77)
                .setLength(986.0)
                .setBarrelLength(508.0)
                .setMuzzleVelocity(960)
                .setCyclicRateOfFire(700)
                .setPracticalRateOfFire(100)
                .setMagazineCapacity(30)
                .setSightingRange(800)
                .setEffectiveFire(550)
                .setPrice(BigDecimal.valueOf(1800))
                .setImageUrl("https://c4.wallpaperflare.com/wallpaper/324/167/817/m16-rifle-backgrounds-hd-wallpaper-preview.jpg")
                .setDescription("In 1964, the M16 entered US military service and the following year was deployed for jungle warfare operations during the Vietnam War.[12] In 1969, the M16A1 replaced the M14 rifle to become the US military's standard service rifle. The M16A1 incorporated numerous modifications including a bolt-assist, chrome-plated bore, protective reinforcement around the magazine release, and revised flash hider.\n" +
                        "\n" +
                        "In 1983, the US Marine Corps adopted the M16A2 rifle and the US Army adopted it in 1986. The M16A2 fires the improved 5.56×45mm (M855/SS109) cartridge and has a newer adjustable rear sight, case deflector, heavy barrel, improved handguard, pistol grip and buttstock, as well as a semi-auto and three-round burst fire selector. Adopted in July 1997, the M16A4 is the fourth generation of the M16 series. It is equipped with a removable carrying handle and Picatinny rail for mounting optics and other ancillary devices.");
        assaultRifles.add(m16);

        AssaultRifleEntity steyrAUG = (AssaultRifleEntity) new AssaultRifleEntity()
                .setName("Steyr AUG")
                .setCountryOfOrigin("Austria")
                .setEnteredService(1978)
                .setCaliber(5.56)
                .setWeight(3.90)
                .setLength(790.0)
                .setBarrelLength(508.0)
                .setMuzzleVelocity(970)
                .setCyclicRateOfFire(680)
                .setPracticalRateOfFire(100)
                .setMagazineCapacity(30)
                .setSightingRange(700)
                .setEffectiveFire(300)
                .setPrice(BigDecimal.valueOf(1700))
                .setImageUrl("https://www.pewpewtactical.com/wp-content/uploads/2018/05/AUG-taking-a-nap-on-a-tree-1-1200x676.jpg")
                .setDescription("The Steyr AUG (German: Armee-Universal-Gewehr, lit. 'army universal rifle') is an Austrian bullpup assault rifle chambered for the 5.56×45mm NATO intermediate cartridge, designed in the 1960s by Steyr-Daimler-Puch, and now manufactured by Steyr Arms GmbH & Co KG.\n" +
                        "\n" +
                        "It was adopted by the Austrian Army in 1978 as the StG 77 (Sturmgewehr 77), where it replaced the 7.62×51mm NATO StG 58 automatic rifle (a licence-built FN FAL). In production since 1978, it is the standard small arm of the Bundesheer and various Austrian federal police units, and its variants have also been adopted by the armed forces of dozens of countries, with some using it as a standard-issue service rifle.\n" +
                        "\n" +
                        "Steyr AUG importation into the United States began in the 1980s as the AUG/SA (SA denoting semiautomatic). President George H.W. Bush banned the AUG via an executive order under the 1989 Assault Weapon Import Ban. Six years into the ban, AUG buyers gained a reprieve as cosmetic changes to the carbine's design allowed importation once again. Changes included the pistol grip being changed into a thumbhole stock, and the gun barrel left unthreaded to prevent attachment of flash hiders and suppressors. The ban sunsetted in 2004, and in 2008 Steyr Arms worked with Sabre Defence to produce parts legally in the U.S.");
        assaultRifles.add(steyrAUG);

        assaultRifleRepository.saveAll(assaultRifles);
    }

    public List<WeaponPictureAndNameViewDTO> getAllAssaultRifles() {
        return assaultRifleRepository
                .findAll()
                .stream()
                .map(ar -> modelMapper.map(ar, WeaponPictureAndNameViewDTO.class))
                .collect(Collectors.toList());
    }

    public FirearmViewDTO getAssaultRifleDetails(Long id) {
        AssaultRifleEntity assaultRifle = assaultRifleRepository.findById(id).get();
        return modelMapper.map(assaultRifle, FirearmViewDTO.class);
    }

    public void buyAssaultRifle(Long assaultRifleId, UserEntity user) throws NotAllowedToBuyException {
//        UserEntity user = userRepository.findUserEntityByUsername(userDetails.getUsername()).orElseThrow();
        if (!user.isActive()) {
            throw new NotAllowedToBuyException("Inactive user!");
        }
        AssaultRifleEntity assaultRifle = assaultRifleRepository.findById(assaultRifleId).get();

        if (user.getDeposit().compareTo(assaultRifle.getPrice()) < 0) {
            throw new NotAllowedToBuyException("You don't have enough money!");
        }


        BigDecimal fundsLeft = user.getDeposit().subtract(assaultRifle.getPrice());
        user.setDeposit(fundsLeft);

        user.getBoughtAssaultRifles().add(assaultRifle);
        assaultRifle.getUsers().add(user);
        userRepository.save(user);
        assaultRifleRepository.save(assaultRifle);
    }

    public void addAssaultRifle(FirearmAddDTO firearmAddDTO) {
        AssaultRifleEntity assaultRifle = modelMapper.map(firearmAddDTO, AssaultRifleEntity.class);
        assaultRifle.setType(FireArmType.ASSAULT_RIFLE);
        assaultRifleRepository.save(assaultRifle);
    }
}
