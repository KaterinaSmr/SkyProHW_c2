package pro.sky.skyprocourse2hw13.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.skyprocourse2hw13.DepartmentNotFoundException;
import pro.sky.skyprocourse2hw13.models.Employee;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DepartmentsServiceTest {
    @Mock
    private EmployeeService employeeServiceMock;
    @InjectMocks
    private DepartmentsServiceImpl out;

    @BeforeEach
    private void setUp(){
        Employee e1 = new Employee("Ivan", "Ivanov", 1, 20000);
        Employee e2 = new Employee("Petr", "Petrov", 2, 12000);
        Employee e3 = new Employee("Tatiana", "Smirnova", 1, 15000);
        Employee e4 = new Employee("Miron", "Gorbachev", 2, 33000);
        Employee e5 = new Employee("Name", "LastName", 2, 11000);
        Employee e6 = new Employee("Name", "AnotherLastName", 2, 10000);

        HashMap<String, Employee> hm = new HashMap<>(Map.of(
                e1.generateKey(), e1,
                e2.generateKey(), e2,
                e3.generateKey(), e3,
                e4.generateKey(), e4,
                e5.generateKey(), e5,
                e6.generateKey(), e6
        ));

        when(employeeServiceMock.index()).thenReturn(hm);
    }

    @Test
    void shouldReturnMaxSalaryEmployeeForDepartment(){
        Employee expected = new Employee("Miron", "Gorbachev", 2, 33000);
        Employee actual = out.getMaxSalaryEmployee(2);
        assertEquals(expected, actual);
    }
    @Test
    void shouldThrowDepartmentNotFoundExceptionForMaxSalary() {
        assertThrows(DepartmentNotFoundException.class, ()->out.getMaxSalaryEmployee(22));
    }

    @Test
    void shouldReturnMinSalaryEmployeeForDepartment() {
        Employee expected = new Employee("Name", "AnotherLastName", 2, 10000);
        Employee actual = out.getMinSalaryEmployee(2);
        assertEquals(expected, actual);
    }
    @Test
    void shouldThrowDepartmentNotFoundExceptionForMinSalary() {
        assertThrows(DepartmentNotFoundException.class, ()->out.getMinSalaryEmployee(11));
    }


    @Test
    void shouldReturnListOfEmployeesForDepartment() {
        List<Employee> expected = new ArrayList<>(List.of(
            new Employee("Ivan", "Ivanov", 1, 20000),
            new Employee("Tatiana", "Smirnova", 1, 15000)
        ));
        List<Employee> actual = out.getAllEmployeesForDepartment(1);
        assertEquals(expected,actual);
    }
    @Test
    void shouldReturnEmptyListWhenWrongDepartment() {
        List<Employee> expected = new ArrayList<>();
        List<Employee> actual = out.getAllEmployeesForDepartment(11);
        assertEquals(expected,actual);
    }

    @Test
    void shouldReturnEmployeesByDepartments() {
        Employee e1 = new Employee("Ivan", "Ivanov", 1, 20000);
        Employee e2 = new Employee("Petr", "Petrov", 2, 12000);
        Employee e3 = new Employee("Tatiana", "Smirnova", 1, 15000);
        Employee e4 = new Employee("Miron", "Gorbachev", 2, 33000);
        Employee e5 = new Employee("Name", "LastName", 2, 11000);
        Employee e6 = new Employee("Name", "AnotherLastName", 2, 10000);
        Map<Integer, List<Employee>> expected = new HashMap<>(Map.of(
           1, Arrays.asList(e1, e3),
           2, Arrays.asList(e2, e4, e5, e6)
        ));
        Map<Integer, List<Employee>> actual = out.getEmployeesByDepartments();

        assertEquals(expected.keySet(), actual.keySet());
        for (Integer i:expected.keySet()) {
            List<Employee> expectedList = expected.get(i);
            List<Employee> actualList = actual.get(i);
            assertTrue(expectedList.containsAll(actualList) && actualList.containsAll(expectedList));
        }

    }
}