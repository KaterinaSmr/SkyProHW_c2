public class SlytherinStudent extends HogwartsStudent{
    private int cunning;
    private int determination;
    private int ambition;
    private int resourcefulness;
    private int lustForPower;

    public SlytherinStudent(String name, int magicMight, int apparationDistance, int cunning,
                            int determination, int ambition, int resourcefulness, int lustForPower) {
        super(name, magicMight, apparationDistance);
        this.cunning = cunning;
        this.determination = determination;
        this.ambition = ambition;
        this.resourcefulness = resourcefulness;
        this.lustForPower = lustForPower;
    }
    protected SlytherinStudent(String name, int[] properties) {
        this(name, properties[0], properties[1], properties[2], properties[3], properties[4], properties[5], properties[6]);
    }

    public int getCunning() {
        return cunning;
    }

    public int getDetermination() {
        return determination;
    }

    public int getAmbition() {
        return ambition;
    }

    public int getResourcefulness() {
        return resourcefulness;
    }

    public int getLustForPower() {
        return lustForPower;
    }

    @Override
    public String toString() {
        return super.toString() + "\n\t"
                + "cunning = " + cunning + ", determination = " + determination + ", ambition = " + ambition
                + ", resourcefulness = " + resourcefulness + ", lustForPower = " + lustForPower;
    }

    private int getTotalScore(){
        return cunning + determination + ambition + resourcefulness + lustForPower;
    }

    public void compareTo(SlytherinStudent o) {
        int scoreDifference = this.getTotalScore() - o.getTotalScore();
        if (scoreDifference < 0) {
            System.out.println(o.getFirstName() + " лучший Слизеринец, чем " + this.getFirstName());
        } else if (scoreDifference > 0){
            System.out.println(this.getFirstName() + " лучший Слизеринец, чем " + o.getFirstName());
        } else {
            System.out.println(this.getFirstName() + " и " + o.getFirstName() + " одинаково хорошие Слизеринцы");
        }

    }
}

