package org.example;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CurrentDate {
    private String currentDate;

    public CurrentDate() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();

        currentDate = dtf.format(now);
    }

    public void setCurrentDate(String currentDate) {
        this.currentDate = currentDate;
    }

    public String getCurrentDate() {
        return currentDate;
    }
}