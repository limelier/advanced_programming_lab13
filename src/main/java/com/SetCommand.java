package com;

import loc.Locales;

import java.util.Locale;
import java.util.Map;

public class SetCommand implements Command {
    private final String key;

    public SetCommand(String key) {
        this.key = key;
    }

    @Override
    public void run() {
        Map<String, Locale> locales = Locales.getAvailable();
        if (locales.containsKey(key)) {
            Locales.setLocale(locales.get(key));
            System.out.println("Locale set.");
        } else {
            System.out.println("Sorry, " + key + " is not a valid locale key. Use 'display' to see available locales.");
        }
    }
}
