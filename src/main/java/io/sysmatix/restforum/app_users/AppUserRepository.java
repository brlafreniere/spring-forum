package io.sysmatix.restforum.app_users;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<AppUser, Long> {
    AppUser findByEmailAddress(String emailAddress);
}
