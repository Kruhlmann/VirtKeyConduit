package dev.kruhlmann.virtkeyconduit.exception;

public class UnknownKeyboardLayoutException extends Exception {
    public UnknownKeyboardLayoutException(String keyboardLayoutIdentifier) {
        super("Unable to find keyboard layout: " + keyboardLayoutIdentifier);
    }
}
