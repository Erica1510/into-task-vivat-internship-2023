package org.example.service;

import org.example.model.Employee;
import org.example.model.Workplace;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class EmployeeDataProcessor {
    private static final String CSV_DELIMITER = ",";
    public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public List<Employee> processEmployeeData(String filePath) {
        List<Employee> employees = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(CSV_DELIMITER);
                String firstName = data[0];
                String lastName = data[1];
                int age = Integer.parseInt(data[2]);
                List<Workplace> workplaces = new ArrayList<>();

                for (int i = 3; i < data.length; i += 3) {


                    String[] company  = data[i].split(";");
                    String name = company[0];
                    LocalDate startDate = LocalDate.parse(company[1],DATE_FORMATTER);
                    LocalDate endDate = LocalDate.parse(company[2],DATE_FORMATTER);
                    workplaces.add(new Workplace(name, startDate, endDate));
                }
                Employee employee = new Employee(firstName,lastName,age,workplaces);
                System.out.println(employee);
                employees.add(new Employee(firstName, lastName, age, workplaces));
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        return employees;
    }

}