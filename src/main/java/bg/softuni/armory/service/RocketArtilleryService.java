package bg.softuni.armory.service;

import bg.softuni.armory.model.entity.artillery.RocketArtilleryEntity;
import bg.softuni.armory.model.entity.dto.RocketArtilleryAddDTO;
import bg.softuni.armory.model.entity.user.UserEntity;
import bg.softuni.armory.model.entity.views.RocketArtilleryViewDTO;
import bg.softuni.armory.model.entity.views.WeaponPictureAndNameViewDTO;
import bg.softuni.armory.model.enums.AccountRole;
import bg.softuni.armory.model.enums.RocketArtilleryType;
import bg.softuni.armory.model.enums.UserType;
import bg.softuni.armory.model.exception.NotAllowedToBuyException;
import bg.softuni.armory.repository.RocketArtilleryRepository;
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
public class RocketArtilleryService {
    private final RocketArtilleryRepository rocketArtilleryRepository;
    private final ModelMapper modelMapper;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public RocketArtilleryService(RocketArtilleryRepository rocketArtilleryRepository, ModelMapper modelMapper, UserRepository userRepository, RoleRepository roleRepository) {
        this.rocketArtilleryRepository = rocketArtilleryRepository;
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    public void seedRocketArtillery() {
        if (rocketArtilleryRepository.count() > 0) {
            return;
        }

        List<RocketArtilleryEntity> rocketArtilleryList = new ArrayList<>();

        RocketArtilleryEntity grad = new RocketArtilleryEntity()
                .setName("BM-21 Grad")
                .setType(RocketArtilleryType.ROCKET_FIELD_ARTILLERY)
                .setCountryOfOrigin("Soviet Union")
                .setEnteredService(1963)
                .setCaliber(122)
                .setNumberOfTubes(40)
                .setRocketWeight(66.6)
                .setWarheadWeight(18.4)
                .setFiringRange(21)
                .setFullSalvoDuration(20)
                .setReloadingTime(7.0)
                .setEngine("ZIL-375 petrol 180hp")
                .setPrice(BigDecimal.valueOf(2300000))
                .setImageURL("https://m.media-amazon.com/images/W/IMAGERENDERING_521856-T1/images/I/81B0rkT+n4L._AC_SL1500_.jpg")
                .setDescription("The M-21 field rocket system with a BM-21 launch vehicle (122 mm multiple rocket launcher (MRL) system) entered service with the Soviet Army in 1963 to replace the aging 140 mm BM-14 system. The launch vehicle consists of a Ural-375D 6x6 truck chassis fitted with a bank of 40 launch tubes arranged in a rectangular shape that can be turned away from the unprotected cab. ");
        rocketArtilleryList.add(grad);

        RocketArtilleryEntity uragan = new RocketArtilleryEntity()
                .setName("BM-27 Uragan")
                .setType(RocketArtilleryType.ROCKET_FIELD_ARTILLERY)
                .setCountryOfOrigin("Soviet Union")
                .setEnteredService(1975)
                .setCaliber(220)
                .setNumberOfTubes(16)
                .setRocketWeight(280.0)
                .setWarheadWeight(100.0)
                .setFiringRange(34)
                .setFullSalvoDuration(20)
                .setReloadingTime(20.0)
                .setEngine("2 x ZIL-375 petrol engines 2 x 180hp")
                .setPrice(BigDecimal.valueOf(3200000))
                .setImageURL("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTYmLzxrcelbRElTsMJu8YgTkYZEwHJ0U4PLQ&usqp=CAU")
                .setDescription("The BM-27 Uragan (hurricane) multiple launch rocket system was developed in the early 1970's. It is also referred as the 9K57. The Uragan entered service with the Soviet Army in 1975. Currently it is in service with at least 10 countries, including Russia. Export operators are Angola, Belarus, Kazakhstan, Syria, Turkmenistan, Ukraine, Uzbekistan, Yemen and some other countries. The Uragan was the largest and most powerful system of its type in service until the late 1980s, when the Smerch was introduced.");
        rocketArtilleryList.add(uragan);

        RocketArtilleryEntity tos1a = new RocketArtilleryEntity()
                .setName("TOS-1A Solntsepyok")
                .setType(RocketArtilleryType.HEAVY_FLAMETHROWER_SYSTEM)
                .setCountryOfOrigin("Russia")
                .setEnteredService(2001)
                .setCaliber(220)
                .setNumberOfTubes(24)
                .setRocketWeight(217.0)
                .setWarheadWeight(45.0)
                .setFiringRange(6)
                .setFullSalvoDuration(12)
                .setReloadingTime(21.0)
                .setEngine("V-84MS diesel 840hp")
                .setPrice(BigDecimal.valueOf(6500000))
                .setImageURL("https://i.pinimg.com/736x/9f/32/51/9f32517470c180a4bee3cc03744eccf4.jpg")
                .setDescription("The TOS-1A heavy flamethrower system is intended for direct fire support of advancing infantry units and main battle tanks and moves in their combat orders. It is extremely effective against entrenched personnel. The TOS-1A is used to clear out buildings, field fortifications and bunkers. It is also effective against light armored vehicles. The heavy flamethrower system is generally similar to multiple launch rocket systems, however it fires different types of rockets and has a much shorter firing range.");
        rocketArtilleryList.add(tos1a);

        RocketArtilleryEntity himars = new RocketArtilleryEntity()
                .setName("M 142 Himars")
                .setType(RocketArtilleryType.ROCKET_FIELD_ARTILLERY)
                .setCountryOfOrigin("United States")
                .setEnteredService(2005)
                .setCaliber(227)
                .setNumberOfTubes(6)
                .setRocketWeight(307.0)
                .setWarheadWeight(120.0)
                .setFiringRange(32)
                .setFullSalvoDuration(30)
                .setReloadingTime(5.0)
                .setEngine("VCaterpillar 3115 ATAAC 6.6-liter diesel 290hp")
                .setPrice(BigDecimal.valueOf(4000000))
                .setImageURL("https://img1.cgtrader.com/items/4036912/1e7fbe7800/large/mlrs-m142-himars-2006-3d-model-1e7fbe7800.jpg")
                .setDescription("M26 is a baseline 227 mm rocket. It is 3.96 m long and weights 307 kg. It has a range of 32 km and. It is fitted with a 120 kg dual-purpose warhead with 644 bomblets. It is effective against troops and vehicles. These rockets were produced in large numbers. However the M26 had a storage life of 25 years. During that time  more capable and accurate rockets were introduced. The M26 was withdrawn from service. In 2009 the US military began to remove its complete stock of over 360 000 M26 artillery rockets from the inventory.");
        rocketArtilleryList.add(himars);

        RocketArtilleryEntity ws22 = new RocketArtilleryEntity()
                .setName("WS-22")
                .setType(RocketArtilleryType.ROCKET_FIELD_ARTILLERY)
                .setCountryOfOrigin("China")
                .setEnteredService(2014)
                .setCaliber(122)
                .setNumberOfTubes(40)
                .setRocketWeight(74.0)
                .setWarheadWeight(21.0)
                .setFiringRange(45)
                .setFullSalvoDuration(null)
                .setReloadingTime(20.0)
                .setEngine("Diesel 315hp")
                .setPrice(BigDecimal.valueOf(2500000))
                .setImageURL("http://www.military-today.com/artillery/ws_22_l1.jpg")
                .setDescription("The WS-22 has a similar layout as the previous PR50 Sandstorm. It has two pods of 122 mm artillery rockets and carries two reload pods. However the WS-22 is based on a more mobile chassis.");
        rocketArtilleryList.add(ws22);

        rocketArtilleryRepository.saveAll(rocketArtilleryList);
    }

    public List<WeaponPictureAndNameViewDTO> getAllRocketArtillery() {
        return rocketArtilleryRepository
                .findAll()
                .stream()
                .map(ra -> modelMapper.map(ra, WeaponPictureAndNameViewDTO.class))
                .collect(Collectors.toList());
    }

    public RocketArtilleryViewDTO getRocketArtilleryDetails(Long id) {
        RocketArtilleryEntity rocketArtillery = rocketArtilleryRepository.findById(id).get();
        RocketArtilleryViewDTO artilleryViewDTO = modelMapper.map(rocketArtillery, RocketArtilleryViewDTO.class);
        artilleryViewDTO.setType(artilleryTypeToString(rocketArtillery.getType()));
        return artilleryViewDTO;
    }

    private String artilleryTypeToString(RocketArtilleryType type) {
        switch (type) {
            case ROCKET_FIELD_ARTILLERY -> {
                return "Rocket Field Artillery";
            }
            case HEAVY_FLAMETHROWER_SYSTEM -> {
                return "Heavy Flamethrower System";
            }
        }
        return null;
    }

    public void buyRocketArtillery(Long rocketArtilleryId, UserDetails userDetails) throws NotAllowedToBuyException {
        UserEntity user = userRepository.findUserEntityByUsername(userDetails.getUsername()).orElseThrow();
        if (!user.isActive()) {
            throw new NotAllowedToBuyException("Inactive user!");
        }
        if ((user.getUserType().equals(UserType.PERSON) || user.getUserType().equals(UserType.PARAMILITARY_ORGANIZATION)) && !user.getRoles().contains(roleRepository.findByName(AccountRole.ADMINISTRATOR))) {
            throw new NotAllowedToBuyException("This weapon is not allowed to be bought by a person or paramilitary organization!");
        }
        RocketArtilleryEntity rocketArtillery = rocketArtilleryRepository.findById(rocketArtilleryId).orElseThrow();

        if (user.getDeposit().compareTo(rocketArtillery.getPrice()) < 0) {
            throw new NotAllowedToBuyException("You don't have enough money!");
        }

        user.getBoughtRocketArtillery().add(rocketArtillery);
        rocketArtillery.getUsers().add(user);

        BigDecimal fundsLeft = user.getDeposit().subtract(rocketArtillery.getPrice());
        user.setDeposit(fundsLeft);

        userRepository.save(user);
        rocketArtilleryRepository.save(rocketArtillery);
    }

    public void addRocketArtillery(RocketArtilleryAddDTO rocketArtilleryAddDTO) {
        RocketArtilleryEntity rocketArtillery = modelMapper.map(rocketArtilleryAddDTO, RocketArtilleryEntity.class);
        rocketArtilleryRepository.save(rocketArtillery);
    }
}
