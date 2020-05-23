package com;

import loc.Locales;

import java.text.MessageFormat;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.format.TextStyle;
import java.util.Arrays;
import java.util.Currency;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class InfoCommand implements Command {
    @Override
    public void run() {
        Locale locale = Locales.getLocale();
        ResourceBundle bundle = Locales.getMessages();
        boolean hasCountry = !locale.getCountry().equals("");

        System.out.println(MessageFormat.format(
                bundle.getString("info"),
                locale.getLanguage()
        ));

        if (hasCountry) {
            System.out.println(bundle.getString("info.country")+ ": " + locale.getDisplayCountry(locale));
        }

        System.out.println(bundle.getString("info.language") + ": " + locale.getDisplayLanguage(locale));

        if (hasCountry) {
            Currency currency = Currency.getInstance(locale);
            System.out.println(String.format(bundle.getString("info.currency") + ": %s (%s)", currency.getCurrencyCode(), currency.getDisplayName(locale)));
        }

        String days = Arrays.stream(DayOfWeek.values())
                .map(day -> day.getDisplayName(TextStyle.FULL, locale))
                .collect(Collectors.joining(", "));
        System.out.println(bundle.getString("info.days") + ": " + days);

        String months = Arrays.stream(Month.values())
                .map(month -> month.getDisplayName(TextStyle.FULL, locale))
                .collect(Collectors.joining(", "));
        System.out.println(bundle.getString("info.months") + ": " + months);

        String today = LocalDateTime.now()
                .format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)
                        .localizedBy(locale));
        System.out.println(bundle.getString("info.today") + ": " + today);
    }
}
