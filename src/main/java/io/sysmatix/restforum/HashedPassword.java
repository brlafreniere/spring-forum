package io.sysmatix.restforum;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.security.SecureRandom;

public class HashedPassword {
    private String hashedPassword;

    public HashedPassword(String passwordText) {
        int strength = 10;

        BCryptPasswordEncoder bCryptPasswordEncoder;
        bCryptPasswordEncoder = new BCryptPasswordEncoder(strength, new SecureRandom());

        hashedPassword = bCryptPasswordEncoder.encode(passwordText);
    }

    public String toString() {
        return hashedPassword.toString();
    }
}
