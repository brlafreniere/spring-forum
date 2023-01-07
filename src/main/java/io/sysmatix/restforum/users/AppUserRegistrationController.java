package io.sysmatix.restforum.users;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

@Controller
public class AppUserRegistrationController {
    @GetMapping("/users/registration")
    public String showRegistrationForm(WebRequest request, Model model) {
        AppUserDto appUserDto = new AppUserDto();
        model.addAttribute("user", appUserDto);
        return "registration";
    }
}
