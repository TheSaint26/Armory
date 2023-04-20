package bg.softuni.armory.web.rest;

import bg.softuni.armory.model.entity.user.UserDTO;
import bg.softuni.armory.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AllUsersRestController {
  private final UserService userService;

    public AllUsersRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/getAllUsers")
    public ResponseEntity<List<UserDTO>> getUsersExceptCurrent(UserDetails userDetails) {
        return ResponseEntity.ok(userService.getOtherUsers(userDetails.getUsername()));
    }
}
