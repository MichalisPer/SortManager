package com.sparta.mp.logging;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

public class CustomFormatter extends Formatter {
    @Override
    public String format(LogRecord record) {
        return LocalDate.now().format(DateTimeFormatter.ISO_DATE)
                + " " + record.getResourceBundleName()
                + " " + record.getLevel()
                + " " + record.getMessage()
                + "\n";
    }
}
