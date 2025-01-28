package org.example;

import Core.Employee;
import Data.EmployeeRepository;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        EmployeeRepository employeeRepo = new EmployeeRepository(10);
        employeeRepo.addEmployee(new Employee(123, "Akshay", 21, "IT"));

        Employee e = employeeRepo.getEmployeeById(123);
        if(e!=null){
            System.out.println(e.getId());
        }

        ArrayList<Employee> employeesWithNameAndDepartment = employeeRepo.getEmployeeInfo("Akshay", "IT");

        for(Employee emp:employeesWithNameAndDepartment){
            System.out.println(emp.getId());
        }

        employeeRepo.updateEmployeeId(123, 121);
        e = employeeRepo.getEmployeeById(121);
        employeeRepo.updateEmployeeDepartment(121, "CS");
    }
}