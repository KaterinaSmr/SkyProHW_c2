public interface TrailerCheckable {
    default void checkTrailer() {
        System.out.println("Проверяем прицеп");
    }
}
