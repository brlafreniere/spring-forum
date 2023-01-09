package io.sysmatix.restforum.app_users;

public class AppUserAlreadyExistsException extends RuntimeException {
    AppUserAlreadyExistsException(String message) {
        super(message);
    }
}