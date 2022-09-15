public class WrongLoginException extends RuntimeException{

    public WrongLoginException() {
        super("Логин должен быть длиной не более 20 символов");
    }
}
