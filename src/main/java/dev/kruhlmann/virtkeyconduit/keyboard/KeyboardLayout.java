package dev.kruhlmann.virtkeyconduit.keyboard;

public interface KeyboardLayout {
    String transcribe(char target);
    String getUniqueStringIdentifier();
}
