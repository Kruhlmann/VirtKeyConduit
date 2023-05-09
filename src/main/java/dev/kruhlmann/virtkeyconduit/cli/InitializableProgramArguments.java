package dev.kruhlmann.virtkeyconduit.cli;

import dev.kruhlmann.virtkeyconduit.keyboard.KeyboardLayout;

public class InitializableProgramArguments {
    private String target;
    private KeyboardLayout layout;

    public InitializableProgramArguments(String target, KeyboardLayout layout) {
        this.target = target;
        this.layout = layout;
    }

    public String getTarget() {
        return this.target;
    }

    public KeyboardLayout getLayout() {
        return this.layout;
    }
}
