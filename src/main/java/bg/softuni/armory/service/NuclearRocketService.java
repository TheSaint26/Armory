package bg.softuni.armory.service;

import bg.softuni.armory.model.entity.dto.NuclearRocketAddDTO;
import bg.softuni.armory.model.entity.views.NuclearRocketViewDTO;
import bg.softuni.armory.model.entity.views.WeaponPictureAndNameViewDTO;
import bg.softuni.armory.model.entity.wmd.NuclearRocketEntity;
import bg.softuni.armory.repository.NuclearRocketRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class NuclearRocketService {
    private final NuclearRocketRepository nuclearRocketRepository;
    private final ModelMapper modelMapper;

    public NuclearRocketService(NuclearRocketRepository nuclearRocketRepository, ModelMapper modelMapper) {
        this.nuclearRocketRepository = nuclearRocketRepository;
        this.modelMapper = modelMapper;
    }

    public void seedNuclearRockets() {
        if (nuclearRocketRepository.count() > 0) {
            return;
        }

        List<NuclearRocketEntity> nuclearRockets = new ArrayList<>();

        NuclearRocketEntity topolM = new NuclearRocketEntity()
                .setName("RT-2PM2 Topol-M")
                .setUsedBy("Russia")
                .setMass(47000)
                .setLength(22.7)
                .setBlastYield(1.0)
                .setWarhead("1 Megaton warhead")
                .setLaunchPlatform("Silo, road-mobile")
                .setMaxSpeed(26400)
                .setOperationalRange(11000)
                .setImageURL("https://www.armyrecognition.com/images/stories/east_europe/russia/missile_vehicle/ss-27_topol-m/Topol-M_SS-27_Stalin_RS-12M2_RT-2PM2_ICBM_Intercontinental_Ballistic_Missile_Russia_925_001.jpg")
                .setDescription("The RT-2PM2 «Topol-M» (Russian: РТ-2ПМ2 «Тополь-М», NATO reporting name: SS-27 \"Sickle B\", other designations: SS-27 Mod 1, RS-12M1, RS-12M2, formerly incorrectly RT-2UTTKh) is one of the most recent intercontinental ballistic missiles to be deployed by Russia (see RS-24 sometimes classified as a Topol-M variant), and the first to be developed after the dissolution of the Soviet Union. It was developed from the RT-2PM Topol mobile intercontinental ballistic missile. ");
        nuclearRockets.add(topolM);

        NuclearRocketEntity sarmat = new NuclearRocketEntity()
                .setName("RS-28 Sarmat")
                .setUsedBy("Russia")
                .setMass(208100)
                .setLength(35.5)
                .setBlastYield(7.5)
                .setWarhead("Thermonuclear, 10 MIRV and 16 Combine with HGV")
                .setLaunchPlatform("Silo")
                .setMaxSpeed(24500)
                .setOperationalRange(18000)
                .setImageURL("https://i.ytimg.com/vi/8GTlSnFsang/maxresdefault.jpg")
                .setDescription("The RS-28 Sarmat (Russian: РС-28 Сармат, named after the Sarmatians; NATO reporting name: SS-X-29] or SS-X-30), often unofficially called Satan II by some media outlets, is a Russian liquid-fueled, MIRV-equipped super-heavy intercontinental ballistic missile (ICBM) produced by the Makeyev Rocket Design Bureau since 2009. It is intended to replace the R-36M ICBM (SS-18 'Satan') in Russia's arsenal");
        nuclearRockets.add(sarmat);

        nuclearRocketRepository.saveAll(nuclearRockets);
    }

    public List<WeaponPictureAndNameViewDTO> getAllNuclearRockets() {
        return nuclearRocketRepository
                .findAll()
                .stream()
                .map(nr -> modelMapper.map(nr, WeaponPictureAndNameViewDTO.class))
                .collect(Collectors.toList());
    }

    public NuclearRocketViewDTO getNuclearRocketDetails(Long id) {
        NuclearRocketEntity nuclearRocket = nuclearRocketRepository.findById(id).get();
        return modelMapper.map(nuclearRocket, NuclearRocketViewDTO.class);
    }

    public void addNuclearRocket(NuclearRocketAddDTO nuclearRocketAddDTO) {
        NuclearRocketEntity nuclearRocket = modelMapper.map(nuclearRocketAddDTO, NuclearRocketEntity.class);
        nuclearRocketRepository.save(nuclearRocket);
    }
}
