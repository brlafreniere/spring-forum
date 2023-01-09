package io.sysmatix.restforum.app_users;

import jakarta.persistence.*;

@Entity
public class AppUser {
    private @Id @GeneratedValue Long id;
    private @Column(unique = true) String emailAddress;
    private String hashedPassword;

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getHashedPassword() { return hashedPassword; }
    public void setHashedPassword(String password) { this.hashedPassword = password; }
}