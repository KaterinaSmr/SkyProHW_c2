package pro.sky.skyprocourse2hw9.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.skyprocourse2hw9.models.Employee;
import pro.sky.skyprocourse2hw9.services.DepartmentService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/departments")
public class DepartmentsController {
    private final DepartmentService departmentService;

    public DepartmentsController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/max-salary")
    public Employee getMaxSalaryEmpForDepartment(@RequestParam("departmentId") Integer department){
        return departmentService.getMaxSalaryEmployee(department);
    }

    @GetMapping("/min-salary")
    public Employee getMinSalaryEmpForDepartment(@RequestParam("departmentId") Integer department){
        return departmentService.getMinSalaryEmployee(department);
    }

    @GetMapping("/all")
    public Map<Integer, List<Employee>> getEmployeesByDepartments(@RequestParam(name = "departmentId", required = false) Integer department) {
        if (department != null){
            return departmentService.getAllEmployeesForDepartment(department);
        }
        return departmentService.getEmployeesByDepartments();
    }
}
