package bg.softuni.armory.web;


import bg.softuni.armory.model.ArmoryUserDetails;
import bg.softuni.armory.model.entity.user.ChangeUsernameDTO;
import bg.softuni.armory.model.entity.user.DepositDTO;
import bg.softuni.armory.model.entity.user.UserEntity;
import bg.softuni.armory.model.entity.user.UserRegisterDTO;
import bg.softuni.armory.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
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

    @ModelAttribute("changeDTO")
    public ChangeUsernameDTO initChangeNameDTO() {
        return new ChangeUsernameDTO();
    }
    @ModelAttribute("depositDTO")
    public DepositDTO initDepositDTO() {
        return new DepositDTO();
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

    @GetMapping("/username")
    public String viewUsername(@AuthenticationPrincipal ArmoryUserDetails userDetails) {
        return "change-username";
    }

    @PostMapping("/update")
    public String editName(@Valid ChangeUsernameDTO changeDTO,
                           BindingResult bindingResult,
                           RedirectAttributes redirectAttributes,
                           @AuthenticationPrincipal ArmoryUserDetails userDetails) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("changeDTO", changeDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.changeDTO", bindingResult);
            return "redirect:/users/username";
        }
        UserEntity user = userService.findUserByUsername(userDetails.getUsername());
        userService.changeUsername(user, changeDTO);
        userDetails.setUsername(changeDTO.getUsername());
        return "username-changed";
    }

    @GetMapping("/deposit-money")
    public String depositView() {
        return "deposit-money";
    }

    @PostMapping("/deposit-money")
    public String depositMoney(@Valid DepositDTO depositDTO,
                               BindingResult bindingResult,
                               RedirectAttributes redirectAttributes,
                               @AuthenticationPrincipal ArmoryUserDetails userDetails) {
        System.out.println();
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("depositDTO", depositDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.depositDTO", bindingResult);
            return "redirect:/users/deposit-money";
        }
        UserEntity user = userService.findUserByUsername(userDetails.getUsername());
        userService.depositMoney(user, depositDTO);
        userDetails.setDeposit(user.getDeposit());
        return "deposit-successful";
    }

    @ResponseStatus(value = HttpStatus.FORBIDDEN)
    @ExceptionHandler({IllegalStateException.class})
    public ModelAndView onNotActiveUser(IllegalStateException illegalStateException) {
        ModelAndView modelAndView = new ModelAndView("not-active-user");
        modelAndView.addObject("errorMsg", illegalStateException.getMessage());

        return modelAndView;
    }
}
