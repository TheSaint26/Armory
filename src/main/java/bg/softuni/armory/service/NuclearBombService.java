package bg.softuni.armory.service;

import bg.softuni.armory.model.entity.dto.NuclearBombAddDTO;
import bg.softuni.armory.model.entity.views.NuclearBombViewDTO;
import bg.softuni.armory.model.entity.views.WeaponPictureAndNameViewDTO;
import bg.softuni.armory.model.entity.wmd.NuclearBombEntity;
import bg.softuni.armory.repository.NuclearBombRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class NuclearBombService {
    private final NuclearBombRepository nuclearBombRepository;
    private final ModelMapper modelMapper;

    public NuclearBombService(NuclearBombRepository nuclearBombRepository, ModelMapper modelMapper) {
        this.nuclearBombRepository = nuclearBombRepository;
        this.modelMapper = modelMapper;
    }

    public void seedNuclearBombs() {
        if (nuclearBombRepository.count() > 0) {
            return;
        }

        List<NuclearBombEntity> nuclearBombs = new ArrayList<>();

        NuclearBombEntity b83 = new NuclearBombEntity()
                .setName("B83")
                .setUsedBy("United States")
                .setMass(1100)
                .setLength(3.7)
                .setBlastYield(1.2)
                .setImageUrl("https://live.staticflickr.com/65535/8218871149_697eaa658a_b.jpg")
                .setDescription("The B83 is a variable-yield thermonuclear gravity bomb developed by the United States in the late 1970s that entered service in 1983.");
        nuclearBombs.add(b83);

        NuclearBombEntity b90 = new NuclearBombEntity()
                .setName("B90")
                .setUsedBy("United States")
                .setMass(350)
                .setLength(3.0)
                .setBlastYield(0.2)
                .setImageUrl("https://global.discourse-cdn.com/business6/uploads/cartridgecollectors/original/3X/4/4/440944054278c6b1878e9338429cc62d91e17d80.jpeg")
                .setDescription("The B90 Nuclear Depth Strike Bomb (NDSB) was an American thermonuclear bomb designed at Lawrence Livermore National Labs in the mid-to-late 1980s and cancelled prior to introduction into military service due to the end of the Cold War.\n" +
                        "The B90 design was intended for use as a naval aircraft weapon, for use as a nuclear depth bomb and as a land attack strike bomb. It was intended to replace the B57 nuclear bomb used by the Navy. The B90 bomb design entered Phase 3 development engineering and was assigned its numerical designation in June 1988. ");
        nuclearBombs.add(b90);

        NuclearBombEntity tatyana = new NuclearBombEntity()
                .setName("RDS-4 Tatyana")
                .setUsedBy("Soviet Union")
                .setMass(450)
                .setLength(3.365)
                .setBlastYield(0.28)
                .setImageUrl("https://www.super-hobby.bg/zdjecia/9/7/0/38049_rd.jpg")
                .setDescription("The Soviet Union's first mass-produced tactical nuclear weapon was based on the RDS-4 and remained in service until 1966. It used a composite core of 4.2 kilograms (9 lb) Pu-239 and 6.8 kilograms (15 lb) 90% enriched U-235 and had a nominal yield of 30 kilotons.[3] The bomb was delivered from a Tu-4 and Tu-16 aircraft. A tactical weapon based on the RDS-4 was also used on September 14, 1954 during Snowball military exercise near Totskoye (similar to Western Desert Rock exercises), when the bomb was dropped by the Tu-4 bomber (the reverse-engineered Boeing B-29). The purpose of this exercise was not to test the bomb itself, but the ability of using it while breaking through enemy defenses (presumably in West Germany). After the explosion Soviet jet fighters were sent to fly through the mushroom cloud while tanks and infantry were forced to move through ground zero");
        nuclearBombs.add(tatyana);

        NuclearBombEntity tzarBomba = new NuclearBombEntity()
                .setName("RDS-220 Tzar Bomba / Big Ivan")
                .setUsedBy("Soviet Union")
                .setMass(27000)
                .setLength(8.0)
                .setBlastYield(58.0)
                .setImageUrl("https://cdn.hswstatic.com/gif/tsar-bomba-2.jpg")
                .setDescription("The Tsar Bomba (Russian: Царь-бо́мба) (code name: Ivan or Vanya), also known by the alphanumerical designation \"AN602\", was a thermonuclear aerial bomb, and the most powerful nuclear weapon ever created and tested. The Soviet physicist Andrei Sakharov oversaw the project at Arzamas-16, while the main work of design was by Sakharov, Viktor Adamsky, Yuri Babayev, Yuri Smirnov, and Yuri Trutnev. The project was ordered by Nikita Khrushchev in July 1961 as part of the Soviet resumption of nuclear testing after the Test Ban Moratorium, with the detonation timed to coincide with the 22nd Congress of the Communist Party of the Soviet Union.");
        nuclearBombs.add(tzarBomba);

        nuclearBombRepository.saveAll(nuclearBombs);
    }

    public List<WeaponPictureAndNameViewDTO> getAllNuclearBombs() {
        return nuclearBombRepository
                .findAll()
                .stream()
                .map(nb -> modelMapper.map(nb, WeaponPictureAndNameViewDTO.class))
                .collect(Collectors.toList());
    }

    public NuclearBombViewDTO getNuclearBombDetails(Long id) {
        NuclearBombEntity nuclearBomb = nuclearBombRepository.findById(id).get();
        return modelMapper.map(nuclearBomb, NuclearBombViewDTO.class);
    }

    public void addNuclearBomb(NuclearBombAddDTO nuclearBombAddDTO) {
        NuclearBombEntity nuclearBomb = modelMapper.map(nuclearBombAddDTO, NuclearBombEntity.class);
        nuclearBombRepository.save(nuclearBomb);
    }
}
