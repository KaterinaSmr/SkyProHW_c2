package pro.sky.skyprocourse2hw9.services;

import org.springframework.stereotype.Service;
import pro.sky.skyprocourse2hw9.DepartmentNotFoundException;
import pro.sky.skyprocourse2hw9.models.Employee;
import pro.sky.skyprocourse2hw9.EmployeeAlreadyAddedException;
import pro.sky.skyprocourse2hw9.EmployeeNotFoundException;

import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private Map<String, Employee> employees;

    public EmployeeServiceImpl() {
        employees = new HashMap<>();
        Employee e1 = new Employee("Ivan", "Ivanov", 1, 20000);
        employees.put(generateKey(e1), e1);
        Employee e2 = new Employee("Petr", "Petrov", 2, 12000);
        employees.put(generateKey(e2), e2);
        Employee e3 = new Employee("Tatiana", "Smirnova", 1, 15000);
        employees.put(generateKey(e3), e3);
        Employee e4 = new Employee("Miron", "Gorbachev", 2, 22000);
        employees.put(generateKey(e4), e4);
        Employee e5 = new Employee("Name", "LastName", 2, 22000);
        employees.put(generateKey(e5), e5);
        Employee e6 = new Employee("Name", "AnotherLastName", 2, 10000);
        employees.put(generateKey(e6), e6);
    }

    @Override
    public Map<String, Employee> index(){
        return employees;
    }

    private String generateKey(Employee employee){
        return employee.getFirstName() + " " + employee.getLastName();
    }

    @Override
    public Employee add(String firstName, String lastName, int department, int salary){
        if (department < 1 || department > 5){
            throw new DepartmentNotFoundException(department);
        }
        Employee employee = new Employee(firstName, lastName, department, salary);
        if (employees.containsKey(generateKey(employee))){
            throw new EmployeeAlreadyAddedException();
        }
        employees.put(generateKey(employee), employee);
        return employee;
    }
    @Override
    public Employee remove(String firstName, String lastName){
        Employee employee = this.find(firstName, lastName);
        if (!employees.remove(generateKey(employee), employee)){
            throw new EmployeeNotFoundException();
        }
        return employee;
    }

    @Override
    public Employee find(String firstName, String lastName){
        Employee employee = new Employee(firstName, lastName);
        Employee employeeFound = employees.get(generateKey(employee));
        if (employeeFound == null || (!employeeFound.getFirstName().equals(firstName) || !employeeFound.getLastName().equals(lastName))) {
            throw new EmployeeNotFoundException();
        }
        return employeeFound;
    }

    public void printAllEmployeesInfo(){
        employees.values().forEach(System.out::println);
    }

    public int calcTotalSalaryAMonth(){
        return employees.values().stream()
                .mapToInt(Employee::getSalary)
                .sum();
    }
    public Employee getMinSalaryEmployee(){
        return employees.values().stream()
                .min(Comparator.comparingInt(Employee::getSalary)).orElse(null);
    }
    public Employee getMaxSalaryEmployee(){
        return employees.values().stream()
                .min(Comparator.comparingInt(Employee::getSalary)).orElse(null);
    }
    public double calcAverageSalary(){
        return  employees.values().stream()
                .mapToDouble(Employee::getSalary).average().orElse(0);
    }

    public void printEmpNames(){
        employees.keySet().forEach(System.out::println);
    }
}
