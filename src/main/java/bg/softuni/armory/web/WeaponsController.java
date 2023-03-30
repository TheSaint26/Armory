package bg.softuni.armory.web;

import bg.softuni.armory.service.AircraftService;
import bg.softuni.armory.service.InfantryFightingVehicleService;
import bg.softuni.armory.service.TankService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/weapons")
public class WeaponsController {
    private final InfantryFightingVehicleService infantryFightingVehicleService;
    private final TankService tankService;
    private final AircraftService aircraftService;

    public WeaponsController(InfantryFightingVehicleService infantryFightingVehicleService, TankService tankService, AircraftService aircraftService) {
        this.infantryFightingVehicleService = infantryFightingVehicleService;
        this.tankService = tankService;
        this.aircraftService = aircraftService;
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
                         @AuthenticationPrincipal UserDetails userDetails) {
        infantryFightingVehicleService.buyIFV(id, userDetails);
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
                          @AuthenticationPrincipal UserDetails userDetails) {
        tankService.buyTank(id, userDetails);
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
                              @AuthenticationPrincipal UserDetails userDetails) {
        aircraftService.buyAircraft(id, userDetails);
        return "boughtItem";
    }

    @GetMapping("/wmd")
    public String weaponsForMassDestruction() {
        return "wmd";
    }
}
