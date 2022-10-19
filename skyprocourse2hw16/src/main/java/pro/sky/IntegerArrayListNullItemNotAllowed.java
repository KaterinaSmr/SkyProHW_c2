package pro.sky;

public class IntegerArrayListNullItemNotAllowed extends RuntimeException{
    public IntegerArrayListNullItemNotAllowed() {
        super("Null Item not allowed");
    }
}
