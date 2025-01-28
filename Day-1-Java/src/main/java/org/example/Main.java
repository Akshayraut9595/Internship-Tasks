package org.example;

import Core.Employee;
import Data.EmployeeRepository;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // creating new employeeRepository
        EmployeeRepository employeeRepo = new EmployeeRepository(10);

        // adding employee
        employeeRepo.addEmployee(new Employee(121, "abc", 21, "IT"));
        employeeRepo.addEmployee(new Employee(122, "bcd", 22, "IT"));
        employeeRepo.addEmployee(new Employee(123, "efg", 23, "CS"));
        employeeRepo.addEmployee(new Employee(124, "hij", 20, "CS"));
        employeeRepo.addEmployee(new Employee(125, "klm", 20, "CS"));
        employeeRepo.addEmployee(new Employee(126, "nop", 20, "IT"));
        employeeRepo.addEmployee(new Employee(127, "pqr", 25, "IT"));
        employeeRepo.addEmployee(new Employee(128, "stu", 26, "CS"));
        employeeRepo.addEmployee(new Employee(129, "pqr", 27, "IT"));
        employeeRepo.addEmployee(new Employee(130, "abc", 21, "IT"));
        employeeRepo.addEmployee(new Employee(131, "bcd", 20, "IT"));

        // retrieve employee by id
        Employee empById = employeeRepo.getEmployeeById(122);

        // retrieve employee by name
        ArrayList<Employee> empByName = employeeRepo.getEmployeeByName("abc");
        for(Employee e:empByName){
            System.out.println(e.getId());
        }

        // retrieve employee by department
        ArrayList<Employee> empByDepartment = employeeRepo.getEmployeeByDepartment("IT");
        for(Employee e:empByDepartment){
            System.out.println(e.getId());
        }

        // retrieve employee by age
        ArrayList<Employee> empByAge = employeeRepo.getEmployeeByAge(20);
        for(Employee e:empByAge){
            System.out.println(e.getId());
        }

        // updating employee id
        employeeRepo.updateEmployeeId(121, 131);

        // updating employee age
        employeeRepo.updateEmployeeAge(131, 25);

        // updating employee name
        employeeRepo.updateEmployeeName(129, "xyz");

        // get all employee
        ArrayList<Employee> empArray = employeeRepo.getEmployeesArray();
        for(Employee e:empArray){
            System.out.println(e.getId()+" "+e.getName());
        }
    }
}