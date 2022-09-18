package pro.sky.skyproc2hw6;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<Employee> index(){
        return employeeService.index();
    }

    @GetMapping("/add")
    public Employee add(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName){
        return employeeService.add(firstName, lastName);
    }

    @GetMapping("/remove")
    public Employee remove(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName){
        return employeeService.remove(firstName, lastName);
    }
    @GetMapping("/find")
    public Employee find(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName){
        return employeeService.find(firstName, lastName);
    }

}
