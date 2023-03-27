package bg.softuni.armory.service;

import bg.softuni.armory.model.entity.IFV.InfantryFightingVehicleEntity;
import bg.softuni.armory.model.entity.tank.TankEntity;
import bg.softuni.armory.model.entity.views.InfantryFightingVehicleViewDTO;
import bg.softuni.armory.model.entity.views.TankViewDTO;
import bg.softuni.armory.model.entity.views.WeaponPictureAndNameViewDTO;
import bg.softuni.armory.repository.TankRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TankService {
    private final TankRepository tankRepository;
    private final ModelMapper modelMapper;

    public TankService(TankRepository tankRepository, ModelMapper modelMapper) {
        this.tankRepository = tankRepository;
        this.modelMapper = modelMapper;
    }

    public void seedTanks() {
        if (tankRepository.count() > 0) {
            return;
        }

        List<TankEntity> tankList = new ArrayList<>();

        TankEntity t72 = new TankEntity()
                .setName("T-72")
                .setCountryOfOrigin("Soviet Union")
                .setEnteredService(1973)
                .setCrew(3)
                .setMainGun("125 mm 2A46M/2A46M-5 smooth-bore gun")
                .setWeight(41.5)
                .setFullLength(9.53)
                .setWidth(3.59)
                .setHeight(2.23)
                .setMainGunCaliber(125)
                .setSecondaryArmament("12.7 mm NSVT or DShK anti-aircraft machine gun")
                .setMachineGun("7.62 mm PKT coax. machine gun")
                .setMainGunAmmoLoad(45)
                .setMachineGunAmmoLoad(2000)
                .setEngine("V12 diesel V-92S2F (T-72B3 & T-72B3M) 780 hp")
                .setMaxRoadSpeed(75)
                .setMaxRange(700)
                .setPrice(BigDecimal.valueOf(1250000))
                .setImageUrl("https://upload.wikimedia.org/wikipedia/commons/thumb/e/e8/ParkPatriot2015part2-19.jpg/1200px-ParkPatriot2015part2-19.jpg")
                .setDescription("The T-72 is a family of Soviet/Russian main battle tanks that entered production in 1969.[9] The T-72 was a development of the T-64, which was troubled by high costs and its reliance on immature developmental technology. About 25,000 T-72 tanks have been built, and refurbishment has enabled many to remain in service for decades. It has been widely exported and has seen service in 40 countries and in numerous conflicts. The Russian T-90 introduced in 1992 and the Chinese Type 99 are further developments of the T-72. Production and development of various modernized T-72 models continues today.");
        tankList.add(t72);

        TankEntity t90 = new TankEntity()
                .setName("T-90M Proryv")
                .setCountryOfOrigin("Russia")
                .setEnteredService(2016)
                .setCrew(3)
                .setMainGun("2A46M-5 125 mm smooth-bore gun")
                .setWeight(46.0)
                .setFullLength(9.63)
                .setWidth(3.78)
                .setHeight(2.22)
                .setMainGunCaliber(125)
                .setSecondaryArmament("12.7mm Kord Heavy machine gun")
                .setMachineGun("7.62 mm PKMT")
                .setMainGunAmmoLoad(43)
                .setMachineGunAmmoLoad(2000)
                .setEngine("V-92S2F")
                .setMaxRoadSpeed(60)
                .setMaxRange(550)
                .setPrice(BigDecimal.valueOf(4250000))
                .setImageUrl("https://i.pinimg.com/originals/99/fe/42/99fe427d38658e67ae195c0f471495ba.jpg")
                .setDescription("The T-90 is a third-generation Russian main battle tank developed from the T-72. It uses a 125 mm 2A46 smoothbore main gun, the 1A45T fire-control system, an upgraded engine, and gunner's thermal sight. Standard protective measures include a blend of steel and composite armour, smoke grenade dischargers, Kontakt-5 explosive reactive armour (ERA) and the Shtora infrared anti-tank guided missile (ATGM) jamming system.\n" +
                        "\n" +
                        "The T-90 was designed and built by Uralvagonzavod, in Nizhny Tagil, Russia. It entered service with the Russian Army in 1992. ");
        tankList.add(t90);

        TankEntity t14 = new TankEntity()
                .setName("T-14 Armata")
                .setCountryOfOrigin("Russia")
                .setEnteredService(2021)
                .setCrew(3)
                .setMainGun("2A82-1M 125 mm smooth-bore cannon")
                .setWeight(55.0)
                .setFullLength(10.7)
                .setWidth(3.5)
                .setHeight(3.30)
                .setMainGunCaliber(125)
                .setSecondaryArmament("12.7mm Kord Heavy machine gun")
                .setMachineGun("7.62 mm PKTM")
                .setMainGunAmmoLoad(45)
                .setMachineGunAmmoLoad(2000)
                .setEngine("Diesel Double Turbocharger 1,100 kW (1,500 hp)")
                .setMaxRoadSpeed(80)
                .setMaxRange(500)
                .setPrice(BigDecimal.valueOf(4600000))
                .setImageUrl("https://euro-sd.com/wp-content/uploads/2020/12/T14-Armata-in-Moskau-2016-Markus-Werren.jpg")
                .setDescription("The T-14 Armata (Russian: Т-14 «Армата»; industrial designation Russian: Объект 148, romanized: Ob'yekt 148, lit. 'Object 148'), is a Russian main battle tank (MBT) based on the Armata Universal Combat Platform.\n" +
                        "\n" +
                        "The Russian Army initially planned to acquire 2,300 T-14s between 2015 and 2020. By 2018, production and fiscal shortfalls delayed this to 2025, before Russia announced the apparent cancellation of the main production run on 30 July 2018. However, as of 2021, the Russian state-owned TASS media agency claimed the Armata had been expected to begin serial production in 2022, with delivery of a test batch of 100 to the 2nd Guards Tamanskaya Motor Rifle Division expected to begin in 2022. The tanks are planned to only be officially transferred following completion of all state tests. In December 2021 the Russian state conglomerate Rostec stated that serial production had commenced, with \"more than 40\" Armata tanks anticipated to be delivered to Russian troops after 2023");
        tankList.add(t14);

        TankEntity abrams = new TankEntity()
                .setName("M-1 Abrams")
                .setCountryOfOrigin("United States")
                .setEnteredService(1980)
                .setCrew(4)
                .setMainGun("105 mm L/52 M68A1 rifled gun")
                .setWeight(60.0)
                .setFullLength(9.77)
                .setWidth(3.66)
                .setHeight(2.44)
                .setMainGunCaliber(105)
                .setSecondaryArmament("12.7 mm M2HB heavy machine gun ")
                .setMachineGun("2 × 7.62 mm M240 machine guns")
                .setMainGunAmmoLoad(55)
                .setMachineGunAmmoLoad(10400)
                .setEngine("Honeywell AGT1500 multi-fuel turbine engine 1,500 shp")
                .setMaxRoadSpeed(72)
                .setMaxRange(426)
                .setPrice(BigDecimal.valueOf(10000000))
                .setImageUrl("https://i.insider.com/6419d84d50c7b20018f16ff8?width=700")
                .setDescription("The M1 Abrams entered service in 1980 and serves as the main battle tank of the United States Army and formerly of the United States Marine Corps (USMC). The export version is used by the armies of Egypt, Kuwait, Saudi Arabia, Australia, Poland and Iraq.");
        tankList.add(abrams);

        TankEntity leopard = new TankEntity()
                .setName("Leopard 2")
                .setCountryOfOrigin("West Germany")
                .setEnteredService(1979)
                .setCrew(4)
                .setMainGun("Rh-120 L/44 120 mm or Rh-120 L/55")
                .setWeight(62.3)
                .setFullLength(9.97)
                .setWidth(3.75)
                .setHeight(3.00)
                .setMainGunCaliber(120)
                .setSecondaryArmament("N/A")
                .setMachineGun("2 × 7.62 mm MG2A1 machine guns")
                .setMainGunAmmoLoad(42)
                .setMachineGunAmmoLoad(4750)
                .setEngine("MTU MB 873 Ka-501 liquid-cooled V12 twin-turbo diesel engine")
                .setMaxRoadSpeed(70)
                .setMaxRange(340)
                .setPrice(BigDecimal.valueOf(5740000))
                .setImageUrl("https://frontierindia.com/wp-content/uploads/2021/11/Rafaels-TROPHY-System-demonstrated-on-the-German-LEOPARD-2-MBT.webp")
                .setDescription("The Leopard 2 is a third generation German main battle tank (MBT). Developed by Krauss-Maffei in the 1970s, the tank entered service in 1979 and replaced the earlier Leopard 1 as the main battle tank of the West German army. Various iterations of the Leopard 2 continue to be operated by the armed forces of Germany, as well as 13 other European countries, and several non-European states around the world, including Canada, Chile, Indonesia, and Singapore. Some operating states have licensed the Leopard 2 design for local production and domestic development.");
        tankList.add(leopard);

        tankRepository.saveAll(tankList);
    }

    public List<WeaponPictureAndNameViewDTO> getAllTanks() {
        return tankRepository
                .findAll()
                .stream()
                .map(t -> modelMapper.map(t, WeaponPictureAndNameViewDTO.class))
                .collect(Collectors.toList());
    }

    public TankViewDTO getTankDetails(Long id) {
        TankEntity tank = tankRepository.findById(id).get();
        return modelMapper.map(tank, TankViewDTO.class);
    }
}
