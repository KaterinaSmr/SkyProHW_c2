public abstract class HogwartsStudent extends Student{
    private int magicMight;
    private int apparationDistance;
    public HogwartsStudent(String name, int magicMight, int apparationDistance) {
        super(name.split(" ")[0], name.split(" ")[1]);
        this.magicMight = magicMight;
        this.apparationDistance = apparationDistance;
    }

    public int getMagicMight() {
        return magicMight;
    }

    public int getApparationDistance() {
        return apparationDistance;
    }

    public void compareMagicTo(HogwartsStudent o) {
        int scoreDifference = this.getMagicMight() - o.getMagicMight();
        if (scoreDifference < 0) {
            System.out.println(o.getFirstName() + " обладает бОльшей мощностью магии, чем " + this.getFirstName());
        } else if (scoreDifference > 0){
            System.out.println(this.getFirstName() + " обладает бОльшей мощностью магии, чем " + o.getFirstName());
        } else {
            System.out.println(this.getFirstName() + " и " + o.getFirstName() + " обладают одинаковой мощностью магии");
        }
    }

    public void compareApparationTo(HogwartsStudent o) {
        int scoreDifference = this.getApparationDistance() - o.getApparationDistance();
        if (scoreDifference < 0) {
            System.out.println(o.getFirstName() + " обладает бОльшим расстоянием трансгрессии, чем " + this.getFirstName());
        } else if (scoreDifference > 0){
            System.out.println(this.getFirstName() + " обладает бОльшим расстоянием трансгрессии, чем " + o.getFirstName());
        } else {
            System.out.println(this.getFirstName() + " и " + o.getFirstName() + " обладают одинаковым расстоянием трансгрессии");
        }
    }

    @Override
    public String toString() {
        return super.toString() + ":\n\t"
                + "magic = " + magicMight + ", apparation = " + apparationDistance;
    }
}
