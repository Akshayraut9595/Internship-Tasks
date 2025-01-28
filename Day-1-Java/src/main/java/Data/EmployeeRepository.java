package Data;

import Core.Employee;

import java.util.ArrayList;
import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EmployeeRepository {
    private static final Logger logger = LoggerFactory.getLogger(EmployeeRepository.class);
    private Employee employeesArray[];
    private int index;
    private int size;
    public EmployeeRepository(int size){
        employeesArray = new Employee[size];
        this.index = 0;
        this.size = size;
        logger.info("Employee Repository created with size {}", size);
    }

//    get all employee
    public ArrayList<Employee> getEmployeesArray() {
        logger.info("Returning all employees");
        return new ArrayList<Employee>(Arrays.asList(employeesArray));
    }

//  adding employee
    public void addEmployee(Employee employee){
        if(employee == null){
            logger.warn("Cannot add null employee");
            return;
        }
        if(index >= size){
            logger.error("Employee size is over");
            return;
        }
        employeesArray[index++] = employee;
        logger.info("Added new employee with id {}", employee.getId());
    }

//    retrieving employee by id
    public Employee getEmployeeById(int id){
        for(int i=0;i<index;i++) {
            Employee e = employeesArray[i];
            int empId = e.getId();
            if (empId == id) {
                logger.info("Employee with give id found");
                return e;
            }
        }
        logger.warn("Employee found with given id");
        return null;
    }

//    retrieving employee by name
    public ArrayList<Employee> getEmployeeByName(String name) {
        ArrayList<Employee> employees = new ArrayList<>();
        if (!name.isEmpty()) {
            for (Employee employee : employeesArray) {
                if (employee!=null && employee.getName().equals(name)) {
                    employees.add(employee);
                }
            }
        }

        if(employees.isEmpty()){
            logger.warn("No employee found with matching name");
        }
        else{
            logger.info("Employee found with matching name");
        }
        return employees;
    }

    //    retrieving employee by name
    public ArrayList<Employee> getEmployeeByDepartment(String department) {
        ArrayList<Employee> employees = new ArrayList<>();
        if (!department.isEmpty()) {
            for (Employee employee : employeesArray) {
                if (employee!=null && employee.getDepartment().equals(department)) {
                    employees.add(employee);
                }
            }
        }

        if(employees.isEmpty()){
            logger.warn("No employee found with matching name");
        }
        else{
            logger.info("Employee found with matching name");
        }
        return employees;
    }

    //    retrieving employee by age
    public ArrayList<Employee> getEmployeeByAge(int age) {
        ArrayList<Employee> employees = new ArrayList<>();
        for (Employee employee : employeesArray) {
            if (employee!=null && employee.getAge() == age) {
                employees.add(employee);
            }
        }

        if(employees.isEmpty()){
            logger.warn("No employee found with matching age");
        }
        else{
            logger.info("Employee found with matching age");
        }
        return employees;
    }


    //    updating employee id
    public String updateEmployeeId(int prevId, int newId){
        for(Employee employee:employeesArray) {
            if (employee!=null && employee.getId() == prevId) {
                employee.setId(newId);
                logger.info("Employee id updated");
                return "Id updated successfully";
            }
        }

        logger.warn("Employee id not updated");
        return "Employee not found";
    }

//    update employee name
    public String updateEmployeeName(int empId, String newName){
        for(Employee employee:employeesArray){
            if(employee!=null && employee.getId() == empId){
                employee.setName(newName);
                logger.info("Name updated successfully");
                return "Name updated successfully";
            }
        }
        logger.warn("Employee not found for updating name with matching id", empId);
        return "Employee not found";
    }

//    update employee age
    public String updateEmployeeAge(int empId, int newAge){
        for(Employee employee:employeesArray){
            if(employee!=null && employee.getId() == empId){
                employee.setAge(newAge);
                logger.info("Employee age updated");
                return "Employee age updated successfully";
            }
        }
        logger.warn("Employee not found for updating age with matching id", empId);
        return "Employee not found";
    }

//    update employee department
    public String updateEmployeeDepartment(int empId, String newDepartment){
        for(Employee employee:employeesArray){
            if(employee!=null && employee.getId() == empId){
                employee.setDepartment(newDepartment);
                logger.info("Employee department updated");
                return "Employee department updated successfully";
            }
        }
        logger.warn("Employee not found for updating department with matching id", empId);
        return "Employee not found";
    }
}
