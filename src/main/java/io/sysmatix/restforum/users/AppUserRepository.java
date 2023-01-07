package io.sysmatix.restforum.users;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<AppUser, Long> {
    AppUser findByEmailAddress(String emailAddress);
}
