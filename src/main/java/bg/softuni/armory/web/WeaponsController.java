package bg.softuni.armory.web;

import bg.softuni.armory.model.ArmoryUserDetails;
import bg.softuni.armory.model.entity.user.UserEntity;
import bg.softuni.armory.model.exception.NotAllowedToBuyException;
import bg.softuni.armory.service.AircraftService;
import bg.softuni.armory.service.InfantryFightingVehicleService;
import bg.softuni.armory.service.TankService;
import bg.softuni.armory.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/weapons")
public class WeaponsController {
    private final InfantryFightingVehicleService infantryFightingVehicleService;
    private final TankService tankService;
    private final AircraftService aircraftService;
    private final UserService userService;

    public WeaponsController(InfantryFightingVehicleService infantryFightingVehicleService, TankService tankService, AircraftService aircraftService, UserService userService) {
        this.infantryFightingVehicleService = infantryFightingVehicleService;
        this.tankService = tankService;
        this.aircraftService = aircraftService;
        this.userService = userService;
    }

    @GetMapping("/all")
    public String allWeapons() {
        return "all-weapons";
    }

    @GetMapping("/firearms")
    public String firearms() {
        return "firearms";
    }

    @GetMapping("/ifv")
    public String ifv(Model model) {
        model.addAttribute("ifvList", infantryFightingVehicleService.getAllIFVs());
        return "infantryFightingVehicles";
    }

    @GetMapping("/ifv/{id}")
    public String ifv(@PathVariable("id") Long id, Model model) {
        model.addAttribute("ifv", infantryFightingVehicleService.getIFVDetails(id));
        System.out.println(infantryFightingVehicleService.getIFVDetails(id).getName());
        return "infantryFightingVehicleDetails";
    }

    @GetMapping("/ifv/buy/{id}")
    public String buyIfv(@PathVariable("id") Long id,
                         @AuthenticationPrincipal ArmoryUserDetails userDetails) throws NotAllowedToBuyException {
        infantryFightingVehicleService.buyIFV(id, userDetails);

        UserEntity user = userService.findUserByUsername(userDetails.getUsername());
        userDetails.setDeposit(user.getDeposit());

        return "boughtItem";
    }

    @GetMapping("/tanks")
    public String tanks(Model model) {
        model.addAttribute("tankList", tankService.getAllTanks());
        return "tanks";
    }
    @GetMapping("/tanks/{id}")
    public String tanks(@PathVariable("id") Long id, Model model) {
        model.addAttribute("tank", tankService.getTankDetails(id));
        return "tankDetails";
    }
    @GetMapping("/tanks/buy/{id}")
    public String buyTank(@PathVariable("id") Long id,
                          @AuthenticationPrincipal ArmoryUserDetails userDetails) throws NotAllowedToBuyException {
        tankService.buyTank(id, userDetails);

        UserEntity user = userService.findUserByUsername(userDetails.getUsername());
        userDetails.setDeposit(user.getDeposit());

        return "boughtItem";
    }

    @GetMapping("/artillery")
    public String artillery() {
        return "artillery";
    }

    @GetMapping("/aircraft")
    public String aircraft(Model model) {
        model.addAttribute("aircraftList", aircraftService.getAllAircraft());
        return "aircraft";
    }

    @GetMapping("/aircraft/{id}")
    public String aircraftDetails(@PathVariable("id") Long id, Model model) {
        model.addAttribute("aircraft", aircraftService.getAircraftDetails(id));
        return "aircraftDetails";
    }

    @GetMapping("/aircraft/buy/{id}")
    public String buyAircraft(@PathVariable("id") Long id,
                              @AuthenticationPrincipal ArmoryUserDetails userDetails) throws NotAllowedToBuyException {
        aircraftService.buyAircraft(id, userDetails);

        UserEntity user = userService.findUserByUsername(userDetails.getUsername());
        userDetails.setDeposit(user.getDeposit());

        return "boughtItem";
    }

    @GetMapping("/wmd")
    public String weaponsForMassDestruction() {
        return "wmd";
    }

    @GetMapping("/mine")
    public String myWeapons() {
        return "myWeapons";
    }

    @ResponseStatus(value = HttpStatus.FORBIDDEN)
    @ExceptionHandler({NotAllowedToBuyException.class})
    public ModelAndView onProductNotFound(NotAllowedToBuyException notAllowedToBuyException) {
        ModelAndView modelAndView = new ModelAndView("not-allowed-to-buy");
        modelAndView.addObject("errorMsg", notAllowedToBuyException.getMessage());

        return modelAndView;
    }
}
