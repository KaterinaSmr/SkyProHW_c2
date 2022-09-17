public class Main {
    public static void main(String[] args) {
        System.out.println(check("java_skypro", "D_1hWiKjjP_9", "D_1hWiKjjP_9"));
        System.out.println(check("java_skypro1231223423424", "pass", "pass"));
    }

    private static boolean check(String login, String password, String confirmPassword) {
        boolean result = false;
        try {
            if (login.length() > 20) {
                throw new WrongLoginException();
            }
            if (!password.equals(confirmPassword)) {
                throw new WrongPasswordException();
            }
            if (!login.matches("\\w{1,20}")){
                throw new WrongLoginException("Логин должен состоять только из символов " +
                        "латинского алфавита и нижнего подчеркивания");
            }
            if (!password.matches("\\w{1,19}")){
                throw new WrongPasswordException("Пароль должен состоять только из символов " +
                        "латинского алфавита и нижнего подчеркивания и быть от 1 до 19 символов длиной");
            }
//            result = login.matches("\\w{1,20}") && password.matches("\\w{1,19}");
        } catch (WrongLoginException e) {
            System.out.println("Логин должен быть длиной не более 20 символов");
            return false;
        } catch (WrongPasswordException e) {
            System.out.println("Password и ConfirmPassword должны совпадать");
            return false;
        }
        return true;
    }

}