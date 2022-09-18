public class HufflepuffStudent extends HogwartsStudent{
    private int hardworkingness;
    private int faithfullness;
    private int honesty;

    public HufflepuffStudent(String name, int magicMight, int apparationDistance,
                             int hardworkingness, int faithfullness, int honesty) {
        super(name, magicMight, apparationDistance);
        this.hardworkingness = hardworkingness;
        this.faithfullness = faithfullness;
        this.honesty = honesty;
    }
    protected HufflepuffStudent(String name, int[] properties) {
        this(name, properties[0], properties[1], properties[2], properties[3], properties[4]);
    }

    public int getHardworkingness() {
        return hardworkingness;
    }

    public int getFaithfullness() {
        return faithfullness;
    }

    public int getHonesty() {
        return honesty;
    }

    @Override
    public String toString() {
        return super.toString() + "\n\t"
                + "hardworkingness = " + hardworkingness + ", faithfullness = " + faithfullness + ", honesty = " + honesty;
    }

    private int getTotalScore(){
        return hardworkingness + faithfullness + honesty;
    }

    public void compareTo(HufflepuffStudent o) {
        int scoreDifference = this.getTotalScore() - o.getTotalScore();
        if (scoreDifference < 0) {
            System.out.println(o.getFirstName() + " лучший Хаффлпафец, чем " + this.getFirstName());
        } else if (scoreDifference > 0){
            System.out.println(this.getFirstName() + " лучший Хаффлпафец, чем " + o.getFirstName());
        } else {
            System.out.println(this.getFirstName() + " и " + o.getFirstName() + " одинаково хорошие Хаффлпафцы");
        }

    }
}
