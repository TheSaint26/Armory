package bg.softuni.armory.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/weapons/add")
public class AddWeaponController {

    @GetMapping
    public String addCustomWeapon() {
        return "addCustomWeapon";
    }
}
