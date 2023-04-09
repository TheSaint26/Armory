package bg.softuni.armory.web;


import bg.softuni.armory.model.entity.user.UserRegisterDTO;
import bg.softuni.armory.service.UserService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UsersController {
    private final UserService userService;

    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @ModelAttribute("userModel")
    public UserRegisterDTO initUserModel() {
        return new UserRegisterDTO();
    }




    @GetMapping("/register")
    public String register() {
        return "auth-register";
    }

    @PostMapping("/register")
    public String register(@Valid UserRegisterDTO userModel,
                           BindingResult bindingResult,
                           RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("userModel", userModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userModel", bindingResult);
            return "redirect:/users/register";
        }
        if (!userService.register(userModel)) {
            redirectAttributes.addFlashAttribute("userModel", userModel);
            redirectAttributes.addFlashAttribute("badCredentials", true);
            return "redirect:/users/register";
        }

        return "redirect:/users/login";
    }

    @GetMapping("/login")
    public String login() {
        return "auth-login";
    }


    @PostMapping("/login-error")
    public String login(@ModelAttribute(UsernamePasswordAuthenticationFilter.SPRING_SECURITY_FORM_USERNAME_KEY) String username,
                        RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute(UsernamePasswordAuthenticationFilter.SPRING_SECURITY_FORM_USERNAME_KEY, username);
        redirectAttributes.addFlashAttribute("badCredentials", true);
        return "redirect:/users/login";
    }

    @GetMapping("/all")
    public String editUsersPage(Model model, @AuthenticationPrincipal UserDetails userDetails) {
        model.addAttribute("allUsers", userService.getOtherUsers(userDetails.getUsername()));
        return "allUsers";
    }

    @GetMapping("/deactivate/{id}")
    public String deactivate(@PathVariable("id") Long id) {
        userService.deactivateUser(id);
        return "redirect:/users/all";
    }

    @GetMapping("/activate/{id}")
    public String activate(@PathVariable("id") Long id) {
        userService.activateUser(id);
        return "redirect:/users/all";
    }

    @GetMapping("/set-moderator/{id}")
    public String setModerator(@PathVariable("id") Long id) {
        userService.giveModeratorPrivileges(id);
        return "redirect:/users/all";
    }

    @GetMapping("/set-user/{id}")
    public String setUser(@PathVariable("id") Long id) {
        userService.takeModeratorPrivileges(id);
        return "redirect:/users/all";
    }
}
