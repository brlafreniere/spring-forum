package io.sysmatix.restforum.user_registrations;

import io.sysmatix.restforum.app_users.AppUser;
import io.sysmatix.restforum.app_users.AppUserAlreadyExistsException;
import io.sysmatix.restforum.app_users.AppUserDto;
import io.sysmatix.restforum.app_users.AppUserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;

@Controller
@RequestMapping("/users/registration")
public class UserRegistrationsController {
    @Autowired
    private AppUserService appUserService;

    @GetMapping("/form")
    public String form(WebRequest request, Model model) {
        AppUserDto appUserDto = new AppUserDto();
        model.addAttribute("user", appUserDto);
        return "users/registration";
    }

    @PostMapping("/create")
    public void create(
        @ModelAttribute("user") @Valid AppUserDto appUserDto,
        HttpServletRequest request,
        Errors errors
    ) {
        try {
            AppUser registered = appUserService.registerNewUserAccount(appUserDto);
        } catch (AppUserAlreadyExistsException ex) {

        }
    }
}
