public abstract class WheeledTransport {
    private String modelName;
    private int wheelsCount;

    public String getModelName() {
        return modelName;
    }

    public int getWheelsCount() {
        return wheelsCount;
    }

    public WheeledTransport(String modelName, int wheelsCount) {
        this.modelName = modelName;
        this.wheelsCount = wheelsCount;
    }

    public void updateTyre() {
        for (int i = 0; i < this.getWheelsCount(); i++) {
            System.out.println("Меняем покрышку");
        }
    }
    protected void updateTyre(String transportType) {
        for (int i = 0; i < this.getWheelsCount(); i++) {
            System.out.println("Меняем покрышку " + transportType);
        }
    }

}
