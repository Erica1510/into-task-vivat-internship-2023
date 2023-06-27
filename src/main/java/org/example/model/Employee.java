package org.example.model;

import java.time.LocalDate;
import java.util.List;

public class Employee {
    private String firstName;
    private String lastName;
    private int age;
    private List<Workplace> workplaces;
    /*private LocalDate startDate;
    private LocalDate endDate;*/

    public Employee(String firstName, String lastName, int age, LocalDate startDate, LocalDate endDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        /*this.startDate = startDate;
        this.endDate = endDate;*/
    }

    public Employee(String firstName, String lastName, int age, List<Workplace> workplaces) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.workplaces = workplaces;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public int getExperienceInMonths() {
        int experience=0;
        for(Workplace workplace : workplaces){
            experience += workplace.getDurationInMonths();
        }
        return experience;
    }
    public List<Workplace> getWorkplaces() {
        return workplaces;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", experienceInMonths=" + getExperienceInMonths() +
                '}';
    }

}
