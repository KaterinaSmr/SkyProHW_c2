package pro.sky.skyprocourse2hw9.services;

import org.springframework.stereotype.Service;
import pro.sky.skyprocourse2hw9.DepartmentNotFoundException;
import pro.sky.skyprocourse2hw9.models.Employee;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class DepartmentsServiceImpl implements DepartmentService {
    private final EmployeeService employees;

    public DepartmentsServiceImpl(EmployeeService employees) {
        this.employees = employees;
    }

    @Override
    public Employee getMaxSalaryEmployee(int department) {
        return employees.index().values().stream()
                .filter(e -> e.getDepartment() == department)
                .max(Comparator.comparingInt(Employee::getSalary))
                .orElseThrow(DepartmentNotFoundException::new);
    }
    @Override
    public Employee getMinSalaryEmployee(int department) {
        return employees.index().values().stream()
                .filter(e -> e.getDepartment() == department)
                .min(Comparator.comparingInt(Employee::getSalary))
                .orElseThrow(DepartmentNotFoundException::new);
    }

    @Override
    public Map<Integer, List<Employee>> getAllEmployeesForDepartment(int department) {
        List<Employee> list= employees.index().values().stream()
                .filter(e-> e.getDepartment() == department)
                .collect(Collectors.toList());
        return new HashMap<>(Map.of(department, list));
    }

    @Override
    public Map<Integer, List<Employee>> getEmployeesByDepartments(){
        return employees.index().values().stream()
                .collect(Collectors.toMap(Employee::getDepartment, e -> new ArrayList<>(List.of(e)), (l1, l2) -> {
                    l1.addAll(l2);
                    return l1;
                }));
    }

/* Не очень понятно из описания задания нужны эти методы или нет, но на всякий случай сделала */

    public void raiseSalary(int increaseRate, int department) {
        employees.index().values().stream()
                .filter(e -> e.getDepartment() == department)
                .forEach(e -> e.setSalary((int) (e.getSalary() * ((float) increaseRate / 100 + 1.0f))));
    }

    public int calcTotalSalaryAMonth(int department) {
        return employees.index().values().stream()
                .filter(e -> e.getDepartment() == department)
                .mapToInt(Employee::getSalary)
                .sum();
    }

    public double calcAverageSalary(int department) {
        return employees.index().values().stream()
                .filter(e -> e.getDepartment() == department)
                .mapToInt(Employee::getSalary)
                .average().orElseThrow(DepartmentNotFoundException::new);

    }
}