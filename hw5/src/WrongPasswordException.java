public class WrongPasswordException extends RuntimeException{
    public WrongPasswordException() {
        super("Password и ConfirmPassword должны совпадать");
    }
}
