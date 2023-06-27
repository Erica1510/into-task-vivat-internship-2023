package org.example.model;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Workplace {
    private String company;
    private LocalDate startDate;
    private LocalDate endDate;

    public Workplace(String company, LocalDate startDate, LocalDate endDate) {
        this.company = company;
        this.startDate = startDate;
        this.endDate = endDate;
    }


    public String getCompany() {
        return company;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public int getDurationInMonths() {
        Period period = Period.between(startDate, endDate);
        return period.getMonths();
    }

    @Override
    public String toString() {
        return "Workplace{" +
                "company='" + company + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}