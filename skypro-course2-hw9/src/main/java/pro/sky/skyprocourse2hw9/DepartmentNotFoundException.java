package pro.sky.skyprocourse2hw9;

public class DepartmentNotFoundException extends RuntimeException{
    public DepartmentNotFoundException() {
        super("Отдел не найден");
    }
    public DepartmentNotFoundException(int department) {
        super("Отдел " + department + " не найден");
    }
}
