import java.util.Random;

public class StudentFactory {
    private static Random random = new Random();
    public static HogwartsStudent createStudent(House faculty, String name){
        switch (faculty){
            case GRYFFINDOR -> {
                return new GryffindorStudent(name, random.ints(5, 1, 100).toArray());
            } case HUFFLEPUFF -> {
                return new HufflepuffStudent(name, random.ints(5, 1, 100).toArray());
            } case RAVENCLAW -> {
                return new RavenclawStudent(name, random.ints(6, 1, 100).toArray());
            } case SLYTHERIN -> {
                return new SlytherinStudent(name, random.ints(7, 1, 100).toArray());
            }
        }
        return null;
    }
}
