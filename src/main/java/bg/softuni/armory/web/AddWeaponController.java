package bg.softuni.armory.web;

import bg.softuni.armory.model.entity.dto.*;
import bg.softuni.armory.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/weapons/add")
public class AddWeaponController {
    private final PistolService pistolService;
    private final AssaultRifleService assaultRifleService;
    private final MachineGunService machineGunService;
    private final SniperService sniperService;
    private final GrenadeLauncherService grenadeLauncherService;
    private final InfantryFightingVehicleService infantryFightingVehicleService;
    private final TankService tankService;
    private final TrunkArtilleryService trunkArtilleryService;
    private final RocketArtilleryService rocketArtilleryService;
    private final AircraftService aircraftService;
    private final NuclearBombService nuclearBombService;
    private final NuclearRocketService nuclearRocketService;

    public AddWeaponController(PistolService pistolService, AssaultRifleService assaultRifleService, MachineGunService machineGunService, SniperService sniperService, GrenadeLauncherService grenadeLauncherService, InfantryFightingVehicleService infantryFightingVehicleService, TankService tankService, TrunkArtilleryService trunkArtilleryService, RocketArtilleryService rocketArtilleryService, AircraftService aircraftService, NuclearBombService nuclearBombService, NuclearRocketService nuclearRocketService) {
        this.pistolService = pistolService;
        this.assaultRifleService = assaultRifleService;
        this.machineGunService = machineGunService;
        this.sniperService = sniperService;
        this.grenadeLauncherService = grenadeLauncherService;
        this.infantryFightingVehicleService = infantryFightingVehicleService;
        this.tankService = tankService;
        this.trunkArtilleryService = trunkArtilleryService;
        this.rocketArtilleryService = rocketArtilleryService;
        this.aircraftService = aircraftService;
        this.nuclearBombService = nuclearBombService;
        this.nuclearRocketService = nuclearRocketService;
    }

    @ModelAttribute("firearmDTO")
    public FirearmAddDTO initFirearmDTO() {
        return new FirearmAddDTO();
    }

    @ModelAttribute("ifvAddDTO")
    public IfvAddDTO initIfvDTO() {
        return new IfvAddDTO();
    }

    @ModelAttribute("tankAddDTO")
    public TankAddDTO initTankAddDTO() {
        return new TankAddDTO();
    }

    @ModelAttribute("trunkArtilleryAddDTO")
    public TrunkArtilleryAddDTO initTrunkArtilleryAddDTO() {
        return new TrunkArtilleryAddDTO();
    }

    @ModelAttribute("rocketArtilleryAddDTO")
    public RocketArtilleryAddDTO initRocketArtilleryAddDTO() {
        return new RocketArtilleryAddDTO();
    }

    @ModelAttribute("aircraftAddDTO")
    public AircraftAddDTO initAircraftAddDTO() {
        return new AircraftAddDTO();
    }

    @ModelAttribute("nuclearBombAddDTO")
    public NuclearBombAddDTO initNuclearBombAddDTO() {
        return new  NuclearBombAddDTO();
    }

    @ModelAttribute("nuclearRocketAddDTO")
    public NuclearRocketAddDTO initNuclearRocketAddDTO() {
        return new NuclearRocketAddDTO();
    }

    @GetMapping
    public String addCustomWeapon() {
        return "addCustomWeapon";
    }

    @GetMapping("/pistol")
    public String addPistol() {
        return "addPistol";
    }

    @PostMapping("/pistol")
    public String addPistol(@Valid FirearmAddDTO firearmAddDTO,
                            BindingResult bindingResult,
                            RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("firearmDTO", firearmAddDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.firearmDTO", bindingResult);
            return "redirect:/weapons/add/pistol";
        }

        pistolService.addPistol(firearmAddDTO);
        return "redirect:/";
    }

    @GetMapping("/assaultRifle")
    public String addAssaultRifle() {
        return "addAssaultRifle";
    }

    @PostMapping("/assaultRifle")
    public String addAssaultRifle(@Valid FirearmAddDTO firearmAddDTO,
                                  BindingResult bindingResult,
                                  RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("firearmDTO", firearmAddDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.firearmDTO", bindingResult);
            return "redirect:/weapons/add/assaultRifle";
        }
        assaultRifleService.addAssaultRifle(firearmAddDTO);
        return "redirect:/";
    }

    @GetMapping("/machineGun")
    public String addMachineGun() {
        return "addMachineGun";
    }

    @PostMapping("/machineGun")
    public String addMachineGun(@Valid FirearmAddDTO firearmAddDTO,
                                BindingResult bindingResult,
                                RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("firearmDTO", firearmAddDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.firearmDTO", bindingResult);
            return "redirect:/weapons/add/machineGun";
        }
        machineGunService.addMachineGun(firearmAddDTO);
        return "redirect:/";
    }

    @GetMapping("/sniper")
    public String addSniper() {
        return "addSniper";
    }

    @PostMapping("/sniper")
    public String addSniper(@Valid FirearmAddDTO firearmAddDTO,
                            BindingResult bindingResult,
                            RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("firearmDTO", firearmAddDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.firearmDTO", bindingResult);
            return "redirect:/weapons/add/sniper";
        }

        sniperService.addSniper(firearmAddDTO);
        return "redirect:/";
    }

    @GetMapping("/add/grenadeLauncher")
    public String addGrenadeLauncher() {
        return "addGrenadeLauncher";
    }

    @PostMapping("/add/grenadeLauncher")
    public String addGrenadeLauncher(@Valid FirearmAddDTO firearmAddDTO,
                                     BindingResult bindingResult,
                                     RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("firearmDTO", firearmAddDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.firearmDTO", bindingResult);
            return "redirect:/weapons/add/grenadeLauncher";
        }

        grenadeLauncherService.addGrenadeLauncher(firearmAddDTO);
        return "redirect:/";
    }

    @GetMapping("/ifv")
    public String addIfv() {
        return "addIfv";
    }

    @PostMapping("/ifv")
    public String addIfv(@Valid IfvAddDTO ifvAddDTO,
                         BindingResult bindingResult,
                         RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("ifvAddDTO", ifvAddDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.ifvAddDTO", bindingResult);
            return "redirect:/weapons/add/ifv";
        }

        infantryFightingVehicleService.addIfv(ifvAddDTO);
        return "redirect:/";
    }

    @GetMapping("/tank")
    public String addTank() {
        return "addTank";
    }

    @PostMapping("/tank")
    public String addTank(@Valid TankAddDTO tankAddDTO,
                          BindingResult bindingResult,
                          RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("tankAddDTO", tankAddDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.tankAddDTO", bindingResult);
            return "redirect:/weapons/add/tank";
        }

        tankService.addTank(tankAddDTO);
        return "redirect:/";
    }

    @GetMapping("/trunkArtillery")
    public String addTrunkArtillery() {
        return "addTrunkArtillery";
    }

    @PostMapping("/trunkArtillery")
    public String addTrunkArtillery(@Valid TrunkArtilleryAddDTO trunkArtilleryAddDTO,
                                    BindingResult bindingResult,
                                    RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("trunkArtilleryAddDTO", trunkArtilleryAddDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.trunkArtilleryAddDTO", bindingResult);
            return "redirect:/weapons/add/trunkArtillery";
        }

        trunkArtilleryService.addTrunkArtillery(trunkArtilleryAddDTO);
        return "redirect:/";
    }

    @GetMapping("/rocketArtillery")
    public String addRocketArtillery() {
        return "addRocketArtillery";
    }

    @PostMapping("/rocketArtillery")
    public String addRocketArtillery(@Valid RocketArtilleryAddDTO rocketArtilleryAddDTO,
                                     BindingResult bindingResult,
                                     RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("rocketArtilleryAddDTO", rocketArtilleryAddDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.rocketArtilleryAddDTO", bindingResult);
            return "redirect:/weapons/add/rocketArtillery";
        }

        rocketArtilleryService.addRocketArtillery(rocketArtilleryAddDTO);
        return "redirect:/";
    }

    @GetMapping("/aircraft")
    public String addAircraft() {
        return "addAircraft";
    }

    @PostMapping("/aircraft")
    public String addAircraft(@Valid AircraftAddDTO aircraftAddDTO,
                              BindingResult bindingResult,
                              RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("aircraftAddDTO", aircraftAddDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.aircraftAddDTO", bindingResult);
            return "redirect:/weapons/add/aircraft";
        }

        aircraftService.addAircraft(aircraftAddDTO);
        return "redirect:/";
    }

    @GetMapping("/nuclearBomb")
    public String addNuclearBomb() {
        return "addNuclearBomb";
    }

    @PostMapping("/nuclearBomb")
    public String addNuclearBomb(@Valid NuclearBombAddDTO nuclearBombAddDTO,
                                 BindingResult bindingResult,
                                 RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("nuclearBombAddDTO", nuclearBombAddDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.nuclearBombAddDTO", bindingResult);
            return "redirect:/weapons/add/nuclearBomb";
        }

        nuclearBombService.addNuclearBomb(nuclearBombAddDTO);
        return "redirect:/";
    }

    @GetMapping("/nuclearRocket")
    public String addNuclearRocket() {
        return "addNuclearRocket";
    }

    @PostMapping("/nuclearRocket")
    public String addNuclearRocket(@Valid NuclearRocketAddDTO nuclearRocketAddDTO,
                                   BindingResult bindingResult,
                                   RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("nuclearRocketAddDTO", nuclearRocketAddDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.nuclearRocketAddDTO", bindingResult);
            return "redirect:/weapons/add/nuclearRocket";
        }
        nuclearRocketService.addNuclearRocket(nuclearRocketAddDTO);
        return "redirect:/";
    }
}
