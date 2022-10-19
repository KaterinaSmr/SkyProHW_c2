package pro.sky;

public class IntegerArrayListElementNotFoundException extends RuntimeException{
    public IntegerArrayListElementNotFoundException(String element) {
        super("Element " + element + " not found");
    }
}
