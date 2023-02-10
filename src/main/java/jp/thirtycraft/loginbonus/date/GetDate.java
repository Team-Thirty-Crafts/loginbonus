package jp.thirtycraft.loginbonus.date;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

public class GetDate {
    static LocalDate today = LocalDate.now();

    public String day = today.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.getDefault());
}
