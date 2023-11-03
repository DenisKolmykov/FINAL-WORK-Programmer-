package petsreestr;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.DateTimeParseException;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckDateFormat {
    
    protected int isBirthDate(String elem){
        Pattern pattern = Pattern.compile("\\d{2}\\s*\\.\\d{2}\\.\\s*\\d{4}");
        Matcher matcher = pattern.matcher(elem);
        if (matcher.find()) {
            DateTimeFormatter formatter = new DateTimeFormatterBuilder()
            .appendPattern("dd.MM.yyyy")
            .toFormatter(Locale.ENGLISH);
    
            try {
                LocalDate currentDate = LocalDate.now();
                LocalDate parsedDate = LocalDate.parse(elem, formatter);
                if (parsedDate.isAfter(currentDate)) {
                    System.out.println("\nATTENTION!\nДата больше текущей");
                    return 0;
                } else {
                return 1;
                }
            } catch (DateTimeParseException e) {
                System.out.println("\nATTENTION!\nНекорректный формат даты");
                return 0;
            }
        }else {
            System.out.println("\nATTENTION!\nНекорректный формат даты");
            return 0;
        }
    }

}
