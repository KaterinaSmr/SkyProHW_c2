public class RavenclawStudent extends HogwartsStudent{
    private int intellect;
    private int wisdom;
    private int wittiness;
    private int creativity;

    public RavenclawStudent(String name, int magicMight, int apparationDistance, int intellect, int wisdom, int wittiness, int creativity) {
        super(name, magicMight, apparationDistance);
        this.intellect = intellect;
        this.wisdom = wisdom;
        this.wittiness = wittiness;
        this.creativity = creativity;
    }
    protected RavenclawStudent(String name, int[] properties) {
        this(name, properties[0], properties[1], properties[2], properties[3], properties[4], properties[5]);
    }

    public int getIntellect() {
        return intellect;
    }

    public int getWisdom() {
        return wisdom;
    }

    public int getWittiness() {
        return wittiness;
    }

    public int getCreativity() {
        return creativity;
    }

    @Override
    public String toString() {
        return super.toString() + "\n\t"
                + "intellect = " + intellect + ", wisdom = " + wisdom + ", wittiness = " + wittiness
                + ", creativity = " + creativity;
    }
    private int getTotalScore(){
        return intellect + wisdom + wittiness + creativity;
    }

    public void compareTo(RavenclawStudent o) {
        int scoreDifference = this.getTotalScore() - o.getTotalScore();
        if (scoreDifference < 0) {
            System.out.println(o.getFirstName() + " лучший Когтевранец, чем " + this.getFirstName());
        } else if (scoreDifference > 0){
            System.out.println(this.getFirstName() + " лучший Когтевранец, чем " + o.getFirstName());
        } else {
            System.out.println(this.getFirstName() + " и " + o.getFirstName() + " одинаково хорошие Когтевранцы");
        }

    }
}
