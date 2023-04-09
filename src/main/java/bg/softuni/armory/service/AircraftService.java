package bg.softuni.armory.service;

import bg.softuni.armory.model.entity.aircraft.AircraftEntity;
import bg.softuni.armory.model.entity.dto.AircraftAddDTO;
import bg.softuni.armory.model.entity.user.UserEntity;
import bg.softuni.armory.model.entity.views.AircraftViewDTO;
import bg.softuni.armory.model.entity.views.WeaponPictureAndNameViewDTO;
import bg.softuni.armory.model.enums.AccountRole;
import bg.softuni.armory.model.enums.AircraftType;
import bg.softuni.armory.model.enums.UserType;
import bg.softuni.armory.model.exception.NotAllowedToBuyException;
import bg.softuni.armory.repository.AircraftRepository;
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
public class AircraftService {
    private final AircraftRepository aircraftRepository;
    private final ModelMapper modelMapper;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public AircraftService(AircraftRepository aircraftRepository, ModelMapper modelMapper, UserRepository userRepository, RoleRepository roleRepository) {
        this.aircraftRepository = aircraftRepository;
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    public void seedAircraft() {
        if (aircraftRepository.count() > 0) {
            return;
        }

        List<AircraftEntity> aircraftEntityList = new ArrayList<>();

        AircraftEntity mig29 = new AircraftEntity()
                .setName("Mikoyan MiG-29")
                .setType(AircraftType.FIGHTER)
                .setCountryOfOrigin("Soviet Union")
                .setCrew(1)
                .setLength(17.32)
                .setWingSpan(11.36)
                .setWeightEmpty(10.9)
                .setWeightFull(18.5)
                .setEngine("2 x Klimov RD-33 turbofans")
                .setMaxSpeed(2445)
                .setMaxRange(2100)
                .setCombatRadius(1500)
                .setCannon("1 x GSh-301 30 mm cannon")
                .setMissiles("2 x R-27R/R1 or R-27T/T1 and 4 x R-60/60M or R-73RM2D air-to-air missiles")
                .setBombs("N/A")
                .setPrice(BigDecimal.valueOf(6500000))
                .setImageUrl("https://robbreport.com/wp-content/uploads/2021/07/6.-MigFlug.jpg?w=800")
                .setDescription("The MiG-29 was developed to meet a Soviet Air Force requirement for a lightweight multi-role fighter. It was a Soviet response to the American F-16. The 9-12 prototype made its first flight in 1977. The new soviet multi-role fighter was approved for production in 1982. The type entered service with Soviet Frontal Aviation in 1986, replacing the MiG-23. With its stunning maneuverability, the MiG-29 re-established the Soviet Union's reputation as a producer of capable combat aircraft. This fighter is known in the West as the Fulcrum. The MiG-29 was built in substantial numbers. About 1 600 fighters of this type were built. Most of them (about 900) were exported. ");
        aircraftEntityList.add(mig29);

        AircraftEntity su35s = new AircraftEntity()
                .setName("Su-35s")
                .setType(AircraftType.MULTI_ROLE_FIGHTER)
                .setCountryOfOrigin("Russia")
                .setCrew(1)
                .setLength(21.9)
                .setWingSpan(15.3)
                .setWeightEmpty(18.4)
                .setWeightFull(34.5)
                .setEngine("2 x Saturn 117S (AL-41F1S)")
                .setMaxSpeed(2390)
                .setMaxRange(3600)
                .setCombatRadius(4500)
                .setCannon("1 x 30 mm cannon with 150 rounds of ammunition")
                .setMissiles("R-27ER, E-27ET, R-73, Kh-29T, Kh-31P, Kh-59M, Kh-35U")
                .setBombs("various free-fall bombs")
                .setPrice(BigDecimal.valueOf(85000000))
                .setImageUrl("https://fullfatthings-keyaero.b-cdn.net/sites/keyaero/files/imported/2021-05-10/img_16-8.jpg")
                .setDescription("Developers refer the Su-35 as 4++ generation fighter. Even though it is basically an upgraded version of the Su-27 that made its first flight back in 1977. The Su-35 is a very fast and highly maneuverable fighter with very long range, high altitude capability and heavy armament. It poses a great threat to Western 4+ generation fighters, such as Eurofighter Typhoon, Dassault Rafale, F-15C or F/A-18E Super Hornet. However it is no match for American F-22 Raptor due to the stealthiness.");
        aircraftEntityList.add(su35s);

        AircraftEntity su57 = new AircraftEntity()
                .setName("Su-57")
                .setType(AircraftType.MULTI_ROLE_FIGHTER)
                .setCountryOfOrigin("Russia")
                .setCrew(1)
                .setLength(22.0)
                .setWingSpan(14.2)
                .setWeightEmpty(18.5)
                .setWeightFull(37.0)
                .setEngine("2 x unspecified Saturn engines")
                .setMaxSpeed(2600)
                .setMaxRange(null)
                .setCombatRadius(null)
                .setCannon("1 x 30 mm cannon")
                .setMissiles("R-74M Archer and R-77M Adder air-to-air missiles")
                .setBombs("Unknown")
                .setPrice(BigDecimal.valueOf(100000000))
                .setImageUrl("https://cdnb.artstation.com/p/assets/images/images/050/675/401/large/ar020-9.jpg?1655401148")
                .setDescription("The Sukhoi Su-57 (Russian: Сухой Су-57; NATO reporting name: Felon) is a twin-engine stealth multirole fighter aircraft developed by Sukhoi.[5] It is the product of the PAK FA (Russian: ПАК ФА, short for: Перспективный авиационный комплекс фронтовой авиации, romanized: Perspektivnyy Aviatsionnyy Kompleks Frontovoy Aviatsii, lit. ''prospective aeronautical complex of front-line air forces'') programme, which was initiated in 1999 as a more modern and affordable alternative to the MFI (Mikoyan Project 1.44/1.42). Sukhoi's internal designation for the aircraft is T-50. The Su-57 is the first aircraft in Russian military service designed with stealth technology and is intended to be the basis for a family of stealth combat aircraft. ");
        aircraftEntityList.add(su57);

        AircraftEntity hornet = new AircraftEntity()
                .setName("Boeing F/A-18A/C Hornet")
                .setType(AircraftType.MULTI_ROLE_FIGHTER)
                .setCountryOfOrigin("United States")
                .setCrew(1)
                .setLength(17.07)
                .setWingSpan(11.43)
                .setWeightEmpty(10.81)
                .setWeightFull(21.88)
                .setEngine("2 x General Electric F404-GE-402 turbofans")
                .setMaxSpeed(1915)
                .setMaxRange(1500)
                .setCombatRadius(1065)
                .setCannon("1 x 20 mm M61A1 Vulcan six-barrel cannon")
                .setMissiles("AIM-120 AMRAAM, AIM-7 Sparrow and AIM-9 Sidewinder air-to-air missiles. AGM-65 Maverick, AGM-84E SLAM, AGM-62 Walleye air-to-ground missiles. AGM-88 HARM anti-radiation missile, AGM-84 Harpoon anti-ship missile")
                .setBombs("GBU-10/12/16 guided bombs, Mk.80 series free fall bombs, CBU-59 cluster bombs and free fall nuclear bomb")
                .setPrice(BigDecimal.valueOf(40000000))
                .setImageUrl("https://images05.military.com/sites/default/files/media/equipment/military-aircraft/f-18cd-hornet/2014/02/f-18cd-hornet_003.jpg")
                .setDescription("The world's premier naval fighter originated as a more sophisticated naval derivative of the Northrop YF-17 that was pitted against the General Dynamics YF-16 in the US Navy's Air Combat Fighter programme of 1976. The YF-17  was selected by the US Navy and eventually adopted as the F/A-18 Hornet. Even though the YF-16 lightweight fighter lost this compwetition for the naval fighter, it was adopted by the US Air Force as the F-16. The first of 11 trials Hornets made its maiden flight on 18 November 1978. Production of the initial F/A-18A single-seat version eventually totalled 371 aircraft, the first US Navy squadron receiving its aircraft in 1983.");
        aircraftEntityList.add(hornet);

        AircraftEntity f22 = new AircraftEntity()
                .setName("F-22 Raptor")
                .setType(AircraftType.MULTI_ROLE_FIGHTER)
                .setCountryOfOrigin("United States")
                .setCrew(1)
                .setLength(18.92)
                .setWingSpan(13.56)
                .setWeightEmpty(14.36)
                .setWeightFull(27.21)
                .setEngine("2 x Pratt & Whitney F119-P-100 turbofans")
                .setMaxSpeed(2500)
                .setMaxRange(2950)
                .setCombatRadius(760)
                .setCannon("1 x M61A2 20 mm cannon")
                .setMissiles("4 x AIM-120C AMRAAMs, 4 x AIM-9M/X Sidewinder air-to-air missiles. GBU-32 joint directed air munition, AGM-88 HARM anti-radiation missiles")
                .setBombs("GBU-22 Paveway III laser guided bombs")
                .setPrice(BigDecimal.valueOf(143000000))
                .setImageUrl("https://upload.wikimedia.org/wikipedia/commons/thumb/0/03/Raptor_F-22_27th.jpg/1200px-Raptor_F-22_27th.jpg")
                .setDescription("Developed to meet the USAF's Advanced Tactical Fighter (ATF) requirement for an F-15 replacement. Requirement for a new fighter was issued in the early 1980s. Two companies competed to meet this USAF requirement, including Lockheed Martin (which teamed up with Boeing and General Dynamics) with a YF-22 prototype and Northrop (which teamed with McDonnel Douglas) with its YF-23. In 1991 the YF-22 design was announced the winner. It was more agile than the YF-23, but less stealthier and slower. Between 1990 to 1997 two YF-22A prototypes evaluated some of the technologies proposed for the production ATF.");
        aircraftEntityList.add(f22);

        AircraftEntity tu22 = new AircraftEntity()
                .setName("Tupolev Tu-22M3M")
                .setType(AircraftType.BOMBER)
                .setCountryOfOrigin("Russia")
                .setCrew(4)
                .setLength(41.46)
                .setWingSpan(34.28)
                .setWeightEmpty(78.0)
                .setWeightFull(126.0)
                .setEngine("2 x Kuznetsov NK-32-02 turbofans")
                .setMaxSpeed(2300)
                .setMaxRange(7000)
                .setCombatRadius(2410)
                .setCannon("1 x M61A2 20 mm cannon")
                .setMissiles("4 x AIM-120C AMRAAMs, 4 x AIM-9M/X Sidewinder air-to-air missiles. GBU-32 joint directed air munition, AGM-88 HARM anti-radiation missiles")
                .setBombs("up to 17 tons of free-fall bombs, including 69 x FAB-250, or 18 x FAB-500, or 8 x FAB-1500")
                .setPrice(BigDecimal.valueOf(1500000000))
                .setImageUrl("https://bulgarianmilitary.com/wp-content/uploads/2021/01/Its-possible-now-for-Russia-to-send-a-Tu-22M3-bomber-to-Syria.jpg")
                .setDescription("The Tupolev Tu-22M (Russian: Туполев Ту-22М; NATO reporting name: Backfire) is a supersonic, variable-sweep wing, long-range strategic and maritime strike bomber developed by the Tupolev Design Bureau in the 1960s. According to some sources, the bomber was believed to be designated Tu-26 at one time. During the Cold War, the Tu-22M was operated by the Soviet Air Forces (VVS) in a missile carrier strategic bombing role, and by the Soviet Naval Aviation (Aviatsiya Voyenno-Morskogo Flota, AVMF) in a long-range maritime anti-shipping role. As of 2021, before the 2022 Russian invasion of Ukraine, there were 66 of the aircraft in service.");
        aircraftEntityList.add(tu22);

        AircraftEntity b52 = new AircraftEntity()
                .setName("Boeing B-52H Stratofortress")
                .setType(AircraftType.BOMBER)
                .setCountryOfOrigin("United States")
                .setCrew(5)
                .setLength(49.05)
                .setWingSpan(56.39)
                .setWeightEmpty(137.0)
                .setWeightFull(229.0)
                .setEngine("8 x Pratt & Whitney TF33-P-3 turbofans")
                .setMaxSpeed(958)
                .setMaxRange(16000)
                .setCombatRadius(12200)
                .setCannon("1 x 20 mm Vulcan six-barreled cannon in tail turret housing")
                .setMissiles("AGM-86C cruise missiles, AGM-142 Have Nap (Rafael Popeye) stand-off precision-guided attack missiles")
                .setBombs("B61 or B83 free-fall thermonuclear bombs, conventional Mk.117 or Mk.83 free-fall bombs")
                .setPrice(BigDecimal.valueOf(11800000000L))
                .setImageUrl("https://www.airforce-technology.com/wp-content/uploads/sites/6/2000/11/1200px-B-52H_static_display_arms_06.jpg")
                .setDescription("The final B-52H was rolled out in June 1962 and with the B-1B and B-2A entering service in only limited numbers, the B-52H has been constantly upgraded to enable it to remain a credible front-line type. With the B-1B increasingly assuming the free-fall nuclear role of the B-52H, this latter type has been reallocated to the force projection role, with weapons that now include the AGM-86C conventionally-armed variant of the nuclear cruise missile and Have Nap missiles. The importance of the B-52H to the USAF's continued need for warplanes with global reach while carrying very heavy warloads is demonstrated by the fact that comprehensive upgrades for the remaining aircraft, both in terms of avionics and weapons systems, are still planned. ");
        aircraftEntityList.add(b52);

        aircraftRepository.saveAll(aircraftEntityList);
    }

    public List<WeaponPictureAndNameViewDTO> getAllAircraft() {
        return aircraftRepository
                .findAll()
                .stream()
                .map(a -> modelMapper.map(a, WeaponPictureAndNameViewDTO.class))
                .collect(Collectors.toList());
    }

    public AircraftViewDTO getAircraftDetails(Long id) {
        AircraftEntity aircraft = aircraftRepository.findById(id).get();
        AircraftViewDTO viewDTO = modelMapper.map(aircraft, AircraftViewDTO.class);
        viewDTO.setType(typeToString(aircraft.getType()));
        return viewDTO;
    }

    private String typeToString(AircraftType type) {
        switch (type) {
            case BOMBER -> {
                return "Bomber";
            }
            case FIGHTER -> {
                return "Fighter";
            }
            case GROUND_ATTACK -> {
                return "Ground Attack";
            }
            case MULTI_ROLE_FIGHTER -> {
                return "Multi Role Fighter";
            }
        }
        return null;
    }

    public void buyAircraft(Long aircraftId, UserDetails userDetails) throws NotAllowedToBuyException {
        UserEntity user = userRepository.findUserEntityByUsername(userDetails.getUsername()).orElseThrow();
        if (!user.isActive()) {
            throw new NotAllowedToBuyException("Inactive user!");
        }
        if ((user.getUserType().equals(UserType.PERSON) || user.getUserType().equals(UserType.PARAMILITARY_ORGANIZATION)) && !user.getRoles().contains(roleRepository.findByName(AccountRole.ADMINISTRATOR))) {
            throw new NotAllowedToBuyException("This weapon is not allowed to be bought by a person or paramilitary organization!");
        }
        AircraftEntity aircraft = aircraftRepository.findById(aircraftId).orElseThrow();
        user.getBoughtAircraft().add(aircraft);
        aircraft.getUsers().add(user);
        userRepository.save(user);
        aircraftRepository.save(aircraft);
    }

    public void addAircraft(AircraftAddDTO aircraftAddDTO) {
        AircraftEntity aircraft = modelMapper.map(aircraftAddDTO, AircraftEntity.class);
        aircraftRepository.save(aircraft);
    }
}
