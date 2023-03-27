package bg.softuni.armory.web;

import bg.softuni.armory.service.RocketArtilleryService;
import bg.softuni.armory.service.TrunkArtilleryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/weapons/artillery")
public class ArtilleryController {
    private final RocketArtilleryService rocketArtilleryService;
    private final TrunkArtilleryService trunkArtilleryService;

    public ArtilleryController(RocketArtilleryService rocketArtilleryService, TrunkArtilleryService trunkArtilleryService) {
        this.rocketArtilleryService = rocketArtilleryService;
        this.trunkArtilleryService = trunkArtilleryService;
    }

    @GetMapping("/trunk")
    public String trunkArtillery(Model model) {
        model.addAttribute("trunkArtilleryList", trunkArtilleryService.getAllTrunkArtillery());
        return "trunkArtillery";
    }
    @GetMapping("/trunk/{id}")
    public String trunkArtilleryDetails(@PathVariable("id") Long id, Model model) {
        model.addAttribute("trunkArtillery", trunkArtilleryService.getTrunkArtilleryDetails(id));
        return "trunkArtilleryDetails";
    }

    @GetMapping("/rocket")
    public String rocketArtillery(Model model) {
        model.addAttribute("rocketArtilleryList", rocketArtilleryService.getAllRocketArtillery());
        return "rocketArtillery";
    }

    @GetMapping("/rocket/{id}")
    public String rocketArtilleryDetails(@PathVariable("id") Long id, Model model) {
        model.addAttribute("rocketArtillery", rocketArtilleryService.getRocketArtilleryDetails(id));
        return "rocketArtilleryDetails";
    }
}
