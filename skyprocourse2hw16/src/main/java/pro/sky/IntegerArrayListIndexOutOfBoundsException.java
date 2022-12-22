package pro.sky;

public class IntegerArrayListIndexOutOfBoundsException extends RuntimeException{
    public IntegerArrayListIndexOutOfBoundsException(String index) {
        super("Index " + index + " out of bounds for IntegerArrayList");
    }
    public IntegerArrayListIndexOutOfBoundsException() {
        super("Index out of bounds for IntegerArrayList");
    }
}
