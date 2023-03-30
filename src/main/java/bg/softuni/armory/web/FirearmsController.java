package bg.softuni.armory.web;

import bg.softuni.armory.service.*;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/weapons/firearms")
public class FirearmsController {
    private final PistolService pistolService;
    private final AssaultRifleService assaultRifleService;
    private final MachineGunService machineGunService;
    private final SniperService sniperService;
    private final GrenadeLauncherService grenadeLauncherService;

    public FirearmsController(PistolService pistolService, AssaultRifleService assaultRifleService, MachineGunService machineGunService, SniperService sniperService, GrenadeLauncherService grenadeLauncherService) {
        this.pistolService = pistolService;
        this.assaultRifleService = assaultRifleService;
        this.machineGunService = machineGunService;
        this.sniperService = sniperService;
        this.grenadeLauncherService = grenadeLauncherService;
    }

    @GetMapping("/pistols")
    public String pistols(Model model) {
        model.addAttribute("pistolsList", pistolService.getPistolsList());
        return "pistols";
    }

    @GetMapping("/assaultRifles")
    public String assaultRifles(Model model) {
        model.addAttribute("assaultRiflesList", assaultRifleService.getAllAssaultRifles());
        return "assaultRifles";
    }

    @GetMapping("/machineGuns")
    public String machineGuns(Model model) {
        model.addAttribute("machineGunsList", machineGunService.getAllMachineGuns());
        return "machineGuns";
    }

    @GetMapping("/snipers")
    public String snipers(Model model) {
        model.addAttribute("snipersList", sniperService.getAllSnipers());
        return "snipers";
    }

    @GetMapping("/grenadeLaunchers")
    public String grenadeLaunchers(Model model) {
        model.addAttribute("launchersList", grenadeLauncherService.getGrenadeLaunchers());
        return "grenadeLaunchers";
    }

    @GetMapping("/pistols/{id}")
    public String getPistolDetails(@PathVariable("id") Long id, Model model) {
        model.addAttribute("firearm", pistolService.getPistolDetails(id));
        return "pistolDetails";
    }
    @GetMapping("/pistols/buy/{id}")
    public String buyPistol(@PathVariable("id") Long id,
                            @AuthenticationPrincipal UserDetails userDetails) {
        pistolService.buyPistol(id, userDetails);
        return "boughtItem";
    }

    @GetMapping("/assaultRifles/{id}")
    public String getAssaultRifleDetails(@PathVariable("id") Long id, Model model) {
        model.addAttribute("firearm", assaultRifleService.getAssaultRifleDetails(id));
        return "assaultRifleDetails";
    }
    @GetMapping("/assaultRifles/buy/{id}")
    public String buyAssaultRifle(@PathVariable("id") Long id,
                                  @AuthenticationPrincipal UserDetails userDetails) {
        assaultRifleService.buyAssaultRifle(id, userDetails);
        return "boughtItem";
    }

    @GetMapping("/machineGuns/{id}")
    public String getMachineGunDetails(@PathVariable("id") Long id, Model model) {
        model.addAttribute("firearm", machineGunService.getMachineGunDetails(id));
        return "machineGunDetails";
    }
    @GetMapping("/machineGuns/buy/{id}")
    public String buyMachineGun(@PathVariable("id") Long id,
                                  @AuthenticationPrincipal UserDetails userDetails) {
        machineGunService.buyMachineGun(id, userDetails);
        return "boughtItem";
    }

    @GetMapping("/snipers/{id}")
    public String getSniperDetails(@PathVariable("id") Long id, Model model) {
        model.addAttribute("firearm", sniperService.getSniperDetails(id));
        return "sniperDetails";
    }
    @GetMapping("/snipers/buy/{id}")
    public String buySniper(@PathVariable("id") Long id,
                                     @AuthenticationPrincipal UserDetails userDetails) {
        sniperService.buySniper(id, userDetails);
        return "boughtItem";
    }

    @GetMapping("/grenadeLaunchers/{id}")
    public String getGrenadeLauncherDetails(@PathVariable("id") Long id, Model model) {
        model.addAttribute("firearm", grenadeLauncherService.getGrenadeLauncherDetails(id));
        return "grenadeLauncherDetails";
    }

    @GetMapping("/grenadeLaunchers/buy/{id}")
    public String buyGrenadeLauncher(@PathVariable("id") Long id,
                                @AuthenticationPrincipal UserDetails userDetails) {
        grenadeLauncherService.buyGrenadeLauncher(id, userDetails);
        return "boughtItem";
    }
}
