package io.sysmatix.restforum.app_users;

import org.springframework.security.core.userdetails.User;

public interface IAppUserService {
    AppUser registerNewUserAccount(AppUserDto appUserDto);
}