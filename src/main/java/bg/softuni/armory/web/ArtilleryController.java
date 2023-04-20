package bg.softuni.armory.web;

import bg.softuni.armory.model.ArmoryUserDetails;
import bg.softuni.armory.model.entity.user.UserEntity;
import bg.softuni.armory.model.exception.NotAllowedToBuyException;
import bg.softuni.armory.service.RocketArtilleryService;
import bg.softuni.armory.service.TrunkArtilleryService;
import bg.softuni.armory.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/weapons/artillery")
public class ArtilleryController {
    private final RocketArtilleryService rocketArtilleryService;
    private final TrunkArtilleryService trunkArtilleryService;
    private final UserService userService;

    public ArtilleryController(RocketArtilleryService rocketArtilleryService, TrunkArtilleryService trunkArtilleryService, UserService userService) {
        this.rocketArtilleryService = rocketArtilleryService;
        this.trunkArtilleryService = trunkArtilleryService;
        this.userService = userService;
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

    @GetMapping("/trunk/buy/{id}")
    public String butTrunkArtillery(@PathVariable("id") Long id,
                                    @AuthenticationPrincipal ArmoryUserDetails userDetails) throws NotAllowedToBuyException {
        trunkArtilleryService.buyTrunkArtillery(id, userDetails);

        UserEntity user = userService.findUserByUsername(userDetails.getUsername());
        userDetails.setDeposit(user.getDeposit());

        return "boughtItem";
    }

    @GetMapping("/rocket")
    public String rocketArtillery(Model model) {
        model.addAttribute("rocketArtilleryList", rocketArtilleryService.getAllRocketArtillery());
        return "rocketArtillery";
    }

    @GetMapping("/rocket/buy/{id}")
    public String buyRocketArtillery(@PathVariable("id") Long id,
                                     @AuthenticationPrincipal ArmoryUserDetails userDetails) throws NotAllowedToBuyException {
        rocketArtilleryService.buyRocketArtillery(id, userDetails);

        UserEntity user = userService.findUserByUsername(userDetails.getUsername());
        userDetails.setDeposit(user.getDeposit());

        return "boughtItem";
    }

    @GetMapping("/rocket/{id}")
    public String rocketArtilleryDetails(@PathVariable("id") Long id, Model model) {
        model.addAttribute("rocketArtillery", rocketArtilleryService.getRocketArtilleryDetails(id));
        return "rocketArtilleryDetails";
    }

    @ResponseStatus(value = HttpStatus.FORBIDDEN)
    @ExceptionHandler({NotAllowedToBuyException.class})
    public ModelAndView onProductNotFound(NotAllowedToBuyException notAllowedToBuyException) {
        ModelAndView modelAndView = new ModelAndView("not-allowed-to-buy");
        modelAndView.addObject("errorMsg", notAllowedToBuyException.getMessage());

        return modelAndView;
    }
}
