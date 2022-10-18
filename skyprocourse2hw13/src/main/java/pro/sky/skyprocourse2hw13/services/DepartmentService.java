package pro.sky.skyprocourse2hw13.services;

import pro.sky.skyprocourse2hw13.models.Employee;

import java.util.List;
import java.util.Map;

public interface DepartmentService {
    Employee getMaxSalaryEmployee(int department);

    Employee getMinSalaryEmployee(int department);

    List<Employee> getAllEmployeesForDepartment(int department);

    Map<Integer, List<Employee>> getEmployeesByDepartments();
}
