package pro.sky;

public class StringArrayListIndexOutOfBoundsException extends RuntimeException{
    public StringArrayListIndexOutOfBoundsException(String index) {
        super("Index " + index + " out of bounds for StringArrayList");
    }
    public StringArrayListIndexOutOfBoundsException() {
        super("Index out of bounds for StringArrayList");
    }
}
