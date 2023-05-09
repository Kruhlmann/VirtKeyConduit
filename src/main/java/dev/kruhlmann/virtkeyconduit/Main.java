package dev.kruhlmann.virtkeyconduit;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import dev.kruhlmann.virtkeyconduit.cli.ArgumentParser;
import dev.kruhlmann.virtkeyconduit.cli.InitializableProgramArguments;
import dev.kruhlmann.virtkeyconduit.exception.InsufficientArgumentsException;
import dev.kruhlmann.virtkeyconduit.exception.UnknownKeyboardLayoutException;

public class Main {
    private static void printUsageString() {
        System.err.println("Usage: vkc <target_string> <layout>");
    }
    
    public static ArrayList<String> readVirshKeyIdentifiers(String[] args) {
        ArgumentParser argumentParser = new ArgumentParser(args);
        ArrayList<String> virshKeyIdentifiers = new ArrayList<>();

        try {
            InitializableProgramArguments cliArgs = argumentParser.parseAsCLIArguments();
            for (int i = 0; i < cliArgs.getTarget().length(); i++) {
                char current_character = cliArgs.getTarget().charAt(i);
                String virshKeyIdentifier = cliArgs.getLayout().transcribe(current_character);
                virshKeyIdentifiers.add(virshKeyIdentifier);

            }
        } catch (InsufficientArgumentsException e) {
            System.err.println("Insufficient arguments.");
            Main.printUsageString();
            System.exit(2);
        } catch (ParserConfigurationException e) {
            System.err.println("Unable to instantiate XML builder");
            e.printStackTrace();
            System.exit(3);
        } catch (SAXException e) {
            System.err.println("Unable to parse XML file");
            e.printStackTrace();
            System.exit(4);
        } catch (IOException e) {
            System.err.println("Error while opening file");
            e.printStackTrace();
            System.exit(5);
        } catch (UnknownKeyboardLayoutException e) {
            System.err.println("Unable to find keyboard layout");
            e.printStackTrace();
            System.exit(6);
        }
        
        return virshKeyIdentifiers;
    }

    public static void main(String[] args) {
        ArrayList<String> virshKeyIdentifiers = Main.readVirshKeyIdentifiers(args);
        for (String virshKeyIdentifier : virshKeyIdentifiers) {
            System.out.println(virshKeyIdentifier);            
        }
        
    }
}
