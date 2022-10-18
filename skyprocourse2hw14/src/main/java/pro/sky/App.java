package pro.sky;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        StringArrayList stringArrayList = new StringArrayList(3);
        System.out.println(stringArrayList);

        stringArrayList.add("Follow the Moskva");
        stringArrayList.add("\nDown to Gorky Park");
        stringArrayList.add("\nListening to the wind of change");
        stringArrayList.add("\nAn August summer night");
        stringArrayList.add("\nSoldiers passing by");
        stringArrayList.add("\nListening to the wind of change");
        System.out.println(stringArrayList);

        stringArrayList.add(1,"JAVA");
        System.out.println(stringArrayList);

        System.out.println("Removed: " + stringArrayList.remove(1));
        System.out.println(stringArrayList);

        stringArrayList.add(2,"JAVA");
        System.out.println("Removed: " + stringArrayList.remove("JAVA"));
        System.out.println(stringArrayList);

        System.out.println("contains: " + stringArrayList.contains("Follow the Moskva"));
        System.out.println("index of: " + stringArrayList.indexOf("\nAn August summer night"));

        stringArrayList.clear();
        System.out.println("empty? " + stringArrayList.isEmpty());
        System.out.println("size = " + stringArrayList.size());

    }
}
