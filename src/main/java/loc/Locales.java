package loc;

import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

public class Locales {
    private static final Map<String, Locale> available = Map.of(
            "en", Locale.ENGLISH,
            "ro", new Locale("ro", "RO")
    );

    public static Map<String, Locale> getAvailable() {
        return available;
    }

    private static Locale locale = Locale.ENGLISH;

    public static Locale getLocale() {
        return locale;
    }

    public static void setLocale(Locale locale) {
        Locales.locale = locale;
        Locales.messages = ResourceBundle.getBundle("Messages", locale);
        Locales.commands = ResourceBundle.getBundle("Commands", locale);
    }

    private static ResourceBundle messages = ResourceBundle.getBundle("Messages", locale);
    private static ResourceBundle commands = ResourceBundle.getBundle("Commands", locale);

    public static ResourceBundle getMessages() {
        return messages;
    }

    public static ResourceBundle getCommands() {
        return commands;
    }
}
