package dev.kruhlmann.virtkeyconduit;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import dev.kruhlmann.virtkeyconduit.exception.UnknownKeyCodeException;

public class XmlLayoutTest {
    @Test
    void shouldConvertKeysFromXmlKeyboardLayoutFile() {
        String[] args = {"ABC", "src/test/resources/testlayout"};
        ArrayList<String> virshKeyIdentifiers = Main.readVirshKeyIdentifiers(args);
        String[] expected = {
            "KEY_A",
            "KEY_B",
            "KEY_C",
        };
        assertArrayEquals(expected, virshKeyIdentifiers.toArray());
    }
    
    @Test
    void shouldEncounterUnknownKeyCode() {
        String[] args = {"D", "src/test/resources/testlayout"};
        assertThrows(UnknownKeyCodeException.class, () -> {
            Main.readVirshKeyIdentifiers(args);
        });
    }

}
