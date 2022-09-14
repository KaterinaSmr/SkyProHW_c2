public class ServiceStation {
    public void check(WheeledTransport wheeledTransport) {
        if (wheeledTransport != null) {
            System.out.println("Обслуживаем " + wheeledTransport.getModelName());
            wheeledTransport.updateTyre();
        }
    }
    public void check(WheeledTransport[] wheeledTransport) {
        for (WheeledTransport transport : wheeledTransport) {
            check(transport);
        }
    }
    public void check(Car car) {
        if (car != null) {
           check((WheeledTransport) car);
            car.checkEngine();
        }
    }
    public void check(Car[] cars) {
        for (Car car : cars) {
            check(car);
        }
    }
    public void check(Truck truck) {
        if (truck != null) {
            check((Car) truck);
            truck.checkTrailer();
        }
    }
    public void check(Truck[] trucks) {
        for (Truck truck : trucks) {
            check(truck);
        }
    }
}