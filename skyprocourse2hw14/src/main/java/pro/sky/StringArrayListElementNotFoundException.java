package pro.sky;

public class StringArrayListElementNotFoundException extends RuntimeException{
    public StringArrayListElementNotFoundException(String element) {
        super("Element " + element + " not found");
    }
}
