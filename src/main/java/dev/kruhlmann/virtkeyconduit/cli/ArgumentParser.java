package dev.kruhlmann.virtkeyconduit.cli;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import dev.kruhlmann.virtkeyconduit.exception.InsufficientArgumentsException;
import dev.kruhlmann.virtkeyconduit.exception.UnknownKeyboardLayoutException;
import dev.kruhlmann.virtkeyconduit.keyboard.KeyboardLayout;
import dev.kruhlmann.virtkeyconduit.keyboard.KeyboardLayoutFactory;

public class ArgumentParser {
    private String[] args;

    public ArgumentParser(String[] args) {
        this.args = args;
    }

    public InitializableProgramArguments parseAsCLIArguments() throws InsufficientArgumentsException, ParserConfigurationException, SAXException, IOException, UnknownKeyboardLayoutException {
        if (args.length < 2) {
            throw new InsufficientArgumentsException();
        }
        String target = args[0];
        KeyboardLayout layout = new KeyboardLayoutFactory().from_string_identifier(args[1]);
        return new InitializableProgramArguments(target, layout);
    }
}
