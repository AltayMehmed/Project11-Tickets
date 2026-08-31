package util;

import exceptions.CommandException;
import java.time.LocalDate;

public class DateValidator {
    public static void validate(String value) throws CommandException {
        try { LocalDate.parse(value); } catch(Exception e) { throw new CommandException("Date must be YYYY-MM-DD."); }
    }
}
