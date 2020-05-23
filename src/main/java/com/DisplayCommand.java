package com;

import loc.Locales;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.Map;

public class DisplayCommand implements Command {
    @Override
    public void run() {
        System.out.println(Locales.getMessages().getString("locales"));

        for (Map.Entry<String, Locale> entry : Locales.getAvailable().entrySet()) {
            String key = entry.getKey();
            Locale locale = entry.getValue();
            System.out.println(key + ": " + locale.getLanguage() + " " + locale.getCountry());
        }

        System.out.println(MessageFormat.format(
                Locales.getMessages().getString("locale.set"),
                Locales.getLocale().getLanguage()
        ));
    }
}
