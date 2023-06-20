package org.example;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Set;

public class Main {


    public static void main(String[] args) {
        String filePath = "src/main/resources/employees.csv";
        EmployeeDataProcessor dataProcessor = new EmployeeDataProcessor();
        List<Employee> employees = dataProcessor.processEmployeeData(filePath);
        dataProcessor.processEmployeeData(employees.toString());
        Set<String> uniqueCompanies = dataProcessor.getUniqueCompanies(employees);

        System.out.println("Unique Companies:");
        for (String company : uniqueCompanies) {
            System.out.println("- " + company);
        }
    }
}