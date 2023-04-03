package bg.softuni.armory.web.rest;

import bg.softuni.armory.model.entity.views.WeaponPictureAndNameViewDTO;
import bg.softuni.armory.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/getUserWeapons")
public class MyWeaponsRestController {
    private final UserService userService;

    public MyWeaponsRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<WeaponPictureAndNameViewDTO>> getUserWeapons(@AuthenticationPrincipal UserDetails userDetails) {
        return ResponseEntity.ok(userService.getAllWeapons(userDetails));
    }
}
