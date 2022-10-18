package pro.sky;

public class StringArrayListNullItemNotAllowed extends RuntimeException{
    public StringArrayListNullItemNotAllowed() {
        super("Null Item not allowed");
    }
}
