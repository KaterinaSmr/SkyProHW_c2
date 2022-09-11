
public class Main {
    public static void main(String[] args) {

        GryffindorStudent harryPotter = (GryffindorStudent) StudentFactory.createStudent(House.GRYFFINDOR, "Гарри Поттер");
        GryffindorStudent hermionyGranger = (GryffindorStudent) StudentFactory.createStudent(House.GRYFFINDOR, "Гермиона Грейнджер");
        GryffindorStudent ronWeasley = (GryffindorStudent) StudentFactory.createStudent(House.GRYFFINDOR, "Рон Уизли");

        SlytherinStudent dracoMalfoy = (SlytherinStudent) StudentFactory.createStudent(House.SLYTHERIN, "Драко Малфой");
        SlytherinStudent grahamMontegry = (SlytherinStudent) StudentFactory.createStudent(House.SLYTHERIN, "Грэхэм Монтегю");
        SlytherinStudent gregoryGoyle = (SlytherinStudent) StudentFactory.createStudent(House.SLYTHERIN, "Грегори Гойл");

        HufflepuffStudent zachariaSmith = (HufflepuffStudent) StudentFactory.createStudent(House.HUFFLEPUFF, "Захария Смит");
        HufflepuffStudent sedricDiggory = (HufflepuffStudent) StudentFactory.createStudent(House.HUFFLEPUFF, "Седрик Диггори");
        HufflepuffStudent justinFinchFlechly = (HufflepuffStudent) StudentFactory.createStudent(House.HUFFLEPUFF, "Джастин Финч-Флетчли");

        RavenclawStudent chouChang = (RavenclawStudent) StudentFactory.createStudent(House.RAVENCLAW, "Чжоу Чанг");
        RavenclawStudent padmaPatil = (RavenclawStudent) StudentFactory.createStudent(House.RAVENCLAW, "Падма Патил");
        RavenclawStudent markusBelby = (RavenclawStudent) StudentFactory.createStudent(House.RAVENCLAW, "Маркус Белби");


        System.out.println(hermionyGranger);
        System.out.println(harryPotter);
        hermionyGranger.compareTo(harryPotter);

        System.out.println();
        System.out.println(dracoMalfoy);
        System.out.println(grahamMontegry);
        dracoMalfoy.compareTo(grahamMontegry);

        System.out.println();
        System.out.println(zachariaSmith);
        System.out.println(justinFinchFlechly);
        zachariaSmith.compareTo(justinFinchFlechly);

        System.out.println();
        System.out.println(padmaPatil);
        System.out.println(markusBelby);
        padmaPatil.compareTo(markusBelby);

        System.out.println();
        System.out.println(ronWeasley);
        System.out.println(sedricDiggory);
        ronWeasley.compareMagicTo(sedricDiggory);

        System.out.println();
        System.out.println(chouChang);
        System.out.println(gregoryGoyle);
        chouChang.compareApparationTo(gregoryGoyle);

    }
}