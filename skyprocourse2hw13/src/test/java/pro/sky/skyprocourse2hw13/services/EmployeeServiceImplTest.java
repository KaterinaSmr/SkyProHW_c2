package pro.sky.skyprocourse2hw13.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pro.sky.skyprocourse2hw13.DepartmentNotFoundException;
import pro.sky.skyprocourse2hw13.EmployeeAlreadyAddedException;
import pro.sky.skyprocourse2hw13.EmployeeNotFoundException;
import pro.sky.skyprocourse2hw13.EmployeeWrongDataException;
import pro.sky.skyprocourse2hw13.models.Employee;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeServiceImplTest {
    private EmployeeService out;

    @BeforeEach
    private void setUp(){
        out = new EmployeeServiceImpl();
        out.add("Ivan", "Turgenev", 3, 10000);
    }

    @Test
    void shouldReturnEmployeeWhenAddIsCalled() {
        Employee expected = new Employee("Alexander", "Pushkin", 1, 30000);
        Employee actual = out.add("Alexander", "Pushkin", 1, 30000);
        assertEquals(expected, actual);
    }
    @Test
    void shouldThrowExceptionWhenNameIsNotAlpha() {
        assertThrows(EmployeeWrongDataException.class, ()-> out.add("232dg", "LastName", 2, 10000));
        assertThrows(EmployeeWrongDataException.class, ()-> out.add("Name", "34.fg", 2, 10000));
        assertThrows(EmployeeWrongDataException.class, ()-> out.add("23!2dg", "34.fg", 2, 10000));
    }
    @Test
    void shouldThrowExceptionWhenDuplicatedEmployeeName() {
        assertThrows(EmployeeAlreadyAddedException.class, ()-> out.add("Ivan", "Turgenev", 2, 10000));
    }
    @Test
    void shouldThrowExceptionWhenDepartmentIsIncorrect(){
        assertThrows(DepartmentNotFoundException.class, ()-> out.add("Nameee", "LastNamee", 22, 10000));
    }

    @Test
    void shouldReturnEmployeeWhenFindIsCalled() {
        Employee expected = new Employee("Ivan", "Turgenev", 1, 30000);
        Employee actual = out.find("Ivan", "Turgenev");
        assertEquals(expected, actual);
    }
    @Test
    void shouldThrowExceptionWhenEmployeeNotFound() {
        assertThrows(EmployeeNotFoundException.class, ()->out.find("Alexei", "Ivanov"));
    }


    @Test
    void shouldReturnEmployeeWhenRemoveIsCalled() {
        Employee expected = new Employee("Ivan", "Turgenev", 1, 30000);
        Employee actual = out.remove("Ivan", "Turgenev");
        assertEquals(expected, actual);
    }
    @Test
    void shouldThrowExceptionWhenEmployeeNotFoundWhenRemoveCalled() {
        assertThrows(EmployeeNotFoundException.class, ()->out.remove("Alexei", "Ivanov"));
    }
}