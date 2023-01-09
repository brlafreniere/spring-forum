package io.sysmatix.restforum.app_users;

import io.sysmatix.restforum.HashedPassword;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class AppUserService implements IAppUserService {
    @Autowired
    private AppUserRepository repository;

    @Override
    public AppUser registerNewUserAccount(AppUserDto appUserDto) throws AppUserAlreadyExistsException {
        if (emailExists(appUserDto.getEmailAddress())) {
            throw new AppUserAlreadyExistsException("There is an account with that email address: "
                + appUserDto.getEmailAddress());
        }
        AppUser appUser = new AppUser();

        appUser.setEmailAddress(appUser.getEmailAddress());
        String hashedPassword = new HashedPassword(appUserDto.getPassword()).toString();
        appUser.setHashedPassword(hashedPassword);
        repository.save(appUser);

        return appUser;
    }

    private boolean emailExists(String email) {
        return repository.findByEmailAddress(email) != null;
    }
}