public class Car extends WheeledTransport implements EngineCheckable {
    public Car(String modelName, int wheelsCount) {
        super(modelName, wheelsCount);
    }

    @Override
    public void checkEngine() {
        System.out.println("Проверяем двигатель автомобиля");
    }

    @Override
    public void updateTyre() {
        super.updateTyre("автомобиля");
    }
}