package dev.kruhlmann.virtkeyconduit.exception;

public class UnknownKeyCodeException extends IndexOutOfBoundsException {
    public UnknownKeyCodeException() {
    }

    public UnknownKeyCodeException(int index) {
        super(index);
    }
}
