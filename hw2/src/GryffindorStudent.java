public class GryffindorStudent extends HogwartsStudent{
    private int nobility;
    private int honor;
    private int courage;

    public GryffindorStudent(String name, int magicMight, int apparationDistance, int nobility, int honor, int courage) {
        super(name, magicMight, apparationDistance);
        this.nobility = nobility;
        this.honor = honor;
        this.courage = courage;
    }

    protected GryffindorStudent(String name, int[] properties) {
        this(name, properties[0], properties[1], properties[2], properties[3], properties[4]);
    }

    public int getNobility() {
        return nobility;
    }

    public int getHonor() {
        return honor;
    }

    public int getCourage() {
        return courage;
    }

    int getTotalScore(){
        return nobility + honor + courage;
    }

    @Override
    public String toString() {
        return super.toString() + "\n\t"
                + "nobility = " + nobility + ", honor = " + honor + ", courage = " + courage;
    }

    public void compareTo(GryffindorStudent o) {
        int scoreDifference = this.getTotalScore() - o.getTotalScore();
        if (scoreDifference < 0) {
            System.out.println(o.getFirstName() + " лучший Гриффиндорец, чем " + this.getFirstName());
        } else if (scoreDifference > 0){
            System.out.println(this.getFirstName() + " лучший Гриффиндорец, чем " + o.getFirstName());
        } else {
            System.out.println(this.getFirstName() + " и " + o.getFirstName() + " одинаково хорошие Гриффиндорцы");
        }
    }
}
