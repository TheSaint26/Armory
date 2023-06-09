package bg.softuni.armory.web;

import bg.softuni.armory.model.ArmoryUserDetails;
import bg.softuni.armory.model.entity.user.UserEntity;
import bg.softuni.armory.model.exception.NotAllowedToBuyException;
import bg.softuni.armory.service.*;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/weapons/firearms")
public class FirearmsController {
    private final PistolService pistolService;
    private final AssaultRifleService assaultRifleService;
    private final MachineGunService machineGunService;
    private final SniperService sniperService;
    private final GrenadeLauncherService grenadeLauncherService;
    private final UserService userService;

    public FirearmsController(PistolService pistolService, AssaultRifleService assaultRifleService, MachineGunService machineGunService, SniperService sniperService, GrenadeLauncherService grenadeLauncherService, UserService userService) {
        this.pistolService = pistolService;
        this.assaultRifleService = assaultRifleService;
        this.machineGunService = machineGunService;
        this.sniperService = sniperService;
        this.grenadeLauncherService = grenadeLauncherService;
        this.userService = userService;
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
                            @AuthenticationPrincipal ArmoryUserDetails userDetails) throws NotAllowedToBuyException {
        UserEntity user = userService.findUserByUsername(userDetails.getUsername());
        pistolService.buyPistol(id, user);

        userDetails.setDeposit(user.getDeposit());
        return "boughtItem";
    }

    @GetMapping("/assaultRifles/{id}")
    public String getAssaultRifleDetails(@PathVariable("id") Long id, Model model) {
        model.addAttribute("firearm", assaultRifleService.getAssaultRifleDetails(id));
        return "assaultRifleDetails";
    }
    @GetMapping("/assaultRifles/buy/{id}")
    public String buyAssaultRifle(@PathVariable("id") Long id,
                                  @AuthenticationPrincipal ArmoryUserDetails userDetails) throws NotAllowedToBuyException {
        UserEntity user = userService.findUserByUsername(userDetails.getUsername());
        assaultRifleService.buyAssaultRifle(id, user);


        userDetails.setDeposit(user.getDeposit());
        return "boughtItem";
    }

    @GetMapping("/machineGuns/{id}")
    public String getMachineGunDetails(@PathVariable("id") Long id, Model model) {
        model.addAttribute("firearm", machineGunService.getMachineGunDetails(id));
        return "machineGunDetails";
    }
    @GetMapping("/machineGuns/buy/{id}")
    public String buyMachineGun(@PathVariable("id") Long id,
                                  @AuthenticationPrincipal ArmoryUserDetails userDetails) throws NotAllowedToBuyException {
        machineGunService.buyMachineGun(id, userDetails);

        UserEntity user = userService.findUserByUsername(userDetails.getUsername());
        userDetails.setDeposit(user.getDeposit());

        return "boughtItem";
    }

    @GetMapping("/snipers/{id}")
    public String getSniperDetails(@PathVariable("id") Long id, Model model) {
        model.addAttribute("firearm", sniperService.getSniperDetails(id));
        return "sniperDetails";
    }
    @GetMapping("/snipers/buy/{id}")
    public String buySniper(@PathVariable("id") Long id,
                                     @AuthenticationPrincipal ArmoryUserDetails userDetails) throws NotAllowedToBuyException {
        sniperService.buySniper(id, userDetails);

        UserEntity user = userService.findUserByUsername(userDetails.getUsername());
        userDetails.setDeposit(user.getDeposit());

        return "boughtItem";
    }

    @GetMapping("/grenadeLaunchers/{id}")
    public String getGrenadeLauncherDetails(@PathVariable("id") Long id, Model model) {
        model.addAttribute("firearm", grenadeLauncherService.getGrenadeLauncherDetails(id));
        return "grenadeLauncherDetails";
    }

    @GetMapping("/grenadeLaunchers/buy/{id}")
    public String buyGrenadeLauncher(@PathVariable("id") Long id,
                                @AuthenticationPrincipal ArmoryUserDetails userDetails) throws NotAllowedToBuyException {
        grenadeLauncherService.buyGrenadeLauncher(id, userDetails);

        UserEntity user = userService.findUserByUsername(userDetails.getUsername());
        userDetails.setDeposit(user.getDeposit());

        return "boughtItem";
    }
    @ResponseStatus(value = HttpStatus.FORBIDDEN)
    @ExceptionHandler({NotAllowedToBuyException.class})
    public ModelAndView onProductNotFound(NotAllowedToBuyException notAllowedToBuyException) {
        ModelAndView modelAndView = new ModelAndView("not-allowed-to-buy");
        modelAndView.addObject("errorMsg", notAllowedToBuyException.getMessage());

        return modelAndView;
  }
}
