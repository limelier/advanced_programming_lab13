package app;

import com.Command;
import com.DisplayCommand;
import com.InfoCommand;
import com.SetCommand;
import loc.Locales;

import java.io.BufferedInputStream;
import java.util.ResourceBundle;
import java.util.Scanner;

public class LocaleExplore {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        ResourceBundle bundle = Locales.getCommands();

        while (true) {
            System.out.println(Locales.getMessages().getString("prompt"));

            String command = in.nextLine();
            String[] commandArgs = command.split(" ");
            Command com = null;

            if (commandArgs[0].equals(bundle.getString("set"))) {
                if (commandArgs.length >= 2) {
                    com = new SetCommand(commandArgs[1]);
                } else {
                    System.out.println(bundle.getString("set.usage"));
                }
            } else if (commandArgs[0].equals(bundle.getString("display"))) {
                com = new DisplayCommand();
            } else if (commandArgs[0].equals(bundle.getString("info"))) {
                com = new InfoCommand();
            } else if (commandArgs[0].equals(bundle.getString("exit"))) {
                break;
            } else if (commandArgs[0].equals(bundle.getString("help"))) {
                System.out.println(bundle.getString("help.text"));
            } else {
                System.out.println(Locales.getMessages().getString("invalid"));
            }

            if (com != null) {
                com.run();
            }
            if (com instanceof SetCommand) {
                bundle = Locales.getCommands();
            }

            System.out.println();
        }
    }
}
