package bg.softuni.armory.web;

import bg.softuni.armory.service.NuclearBombService;
import bg.softuni.armory.service.NuclearRocketService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/weapons/wmd")
public class WmdController {
    private final NuclearBombService nuclearBombService;
    private final NuclearRocketService nuclearRocketService;

    public WmdController(NuclearBombService nuclearBombService, NuclearRocketService nuclearRocketService) {
        this.nuclearBombService = nuclearBombService;
        this.nuclearRocketService = nuclearRocketService;
    }

    @GetMapping("/bombs")
    public String nuclearBombs(Model model) {
        model.addAttribute("nuclearBombsList", nuclearBombService.getAllNuclearBombs());
        return "nuclearBombs";
    }
    @GetMapping("/bombs/{id}")
    public String nuclearBombDetails(@PathVariable("id") Long id, Model model) {
        model.addAttribute("nuclearBomb", nuclearBombService.getNuclearBombDetails(id));
        return "nuclearBombDetails";
    }

    @GetMapping("/rockets")
    public String nuclearRockets(Model model) {
        model.addAttribute("nuclearRocketsList", nuclearRocketService.getAllNuclearRockets());
        return "nuclearRockets";
    }
    @GetMapping("/rockets/{id}")
    public String nuclearRocketDetails(@PathVariable("id") Long id, Model model) {
        model.addAttribute("nuclearRocket", nuclearRocketService.getNuclearRocketDetails(id));
        return "nuclearRocketDetails";
    }
}
