public class WrongLoginException extends Exception{

    public WrongLoginException() {
        super("Логин должен быть длиной не более 20 символов");
    }
    public WrongLoginException(String message) {
        super(message);
    }
}
