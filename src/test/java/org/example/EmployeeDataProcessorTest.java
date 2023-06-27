package org.example;

import org.example.model.Employee;
import org.example.service.EmployeeDataProcessor;
import org.example.service.EmployeeService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

public class EmployeeDataProcessorTest {
    @Test
    public void testProcessEmployeeData() {
        EmployeeDataProcessor dataProcessor = new EmployeeDataProcessor();
        List<Employee> employees = dataProcessor.processEmployeeData("src/main/resources/employees.csv");
        Assertions.assertEquals(10, employees.size());

        Employee firstEmployee = employees.get(0);
        Assertions.assertEquals("John", firstEmployee.getFirstName());
        Assertions.assertEquals("Smith", firstEmployee.getLastName());
        Assertions.assertEquals(25, firstEmployee.getAge());
        Assertions.assertEquals(9, firstEmployee.getExperienceInMonths());

        Employee lastEmployee = employees.get(9);
        Assertions.assertEquals("Olivia", lastEmployee.getFirstName());
        Assertions.assertEquals("Lewis", lastEmployee.getLastName());
        Assertions.assertEquals(26, lastEmployee.getAge());
        Assertions.assertEquals(9, lastEmployee.getExperienceInMonths());
    }

    @Test
    public void testGetUniqueCompanies() {
        EmployeeDataProcessor dataProcessor = new EmployeeDataProcessor();
        List<Employee> employees = dataProcessor.processEmployeeData("src/main/resources/employees.csv");

        Set<String> uniqueCompanies = EmployeeService.getUniqueCompanies(employees);

        Assertions.assertEquals(3, uniqueCompanies.size());
        Assertions.assertTrue(uniqueCompanies.contains("Google"));
        Assertions.assertTrue(uniqueCompanies.contains("Microsoft"));
        Assertions.assertTrue(uniqueCompanies.contains("Apple"));
    }
}