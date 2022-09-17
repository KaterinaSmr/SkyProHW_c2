public class WrongPasswordException extends Exception{
    public WrongPasswordException() {
        super("Password и ConfirmPassword должны совпадать");
    }
    public WrongPasswordException(String message){
        super(message);
    }
}
