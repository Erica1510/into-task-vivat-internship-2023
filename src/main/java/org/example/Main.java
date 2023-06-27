package org.example;

import org.example.model.Employee;
import org.example.service.EmployeeDataProcessor;
import org.example.service.EmployeeService;

import java.util.List;
import java.util.Set;

public class Main {


    public static void main(String[] args) {
        String filePath = "src/main/resources/employees.csv";
        EmployeeDataProcessor dataProcessor = new EmployeeDataProcessor();
        List<Employee> employees = dataProcessor.processEmployeeData(filePath);
        dataProcessor.processEmployeeData(employees.toString());
        Set<String> uniqueCompanies = EmployeeService.getUniqueCompanies(employees);

        System.out.println("Unique Companies:");
        for (String company : uniqueCompanies) {
            System.out.println("- " + company);
        }
    }
}