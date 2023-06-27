package org.example.service;

import org.example.model.Employee;
import org.example.model.Workplace;
import org.example.service.EmployeeDataProcessor;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class EmployeeService {
    public static Set<String> getUniqueCompanies(List<Employee> employees) {
        Set<String> uniqueCompanies = new HashSet<>();

        for (Employee employee : employees) {
            List<Workplace> workplaces = employee.getWorkplaces();
            for (Workplace workplace : workplaces) {
                uniqueCompanies.add(workplace.getCompany());
            }
        }

        return uniqueCompanies;
    }

    public List<Employee> processEmployeeData(String filePath) {
        EmployeeDataProcessor dataProcessor = new EmployeeDataProcessor();
        return dataProcessor.processEmployeeData(filePath);
    }
}
