public interface EngineCheckable {
    default void checkEngine() {
        System.out.println("Проверяем двигатель");
    }
}
