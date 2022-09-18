public class Truck extends Car implements TrailerCheckable {
    public Truck(String modelName, int wheelsCount) {
        super(modelName, wheelsCount);
    }

    @Override
    public void updateTyre() {
        super.updateTyre("грузовика");
    }

    @Override
    public void checkEngine() {
        System.out.println("Проверяем двигатель грузовика");
    }

    @Override
    public void checkTrailer() {
        System.out.println("Проверяем прицеп грузовика");
    }
}