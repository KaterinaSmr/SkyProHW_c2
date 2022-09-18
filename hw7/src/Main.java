
import java.util.*;

public class Main {
    public static void main(String[] args) {
//        Напишите код, с помощью которого можно напечатать только нечетные числа в консоль.
//        Код должен работать с любой последовательностью и объемом списка чисел.
        List<Integer> nums = new ArrayList<>(List.of(1, 1, 2, 3, 4, 4, 5, 5, 6, 7, 0));
        task1(nums);

//        Напишите код, с помощью которого можно напечатать только четные числа без повторений в порядке возрастания
        task2(nums);

//        Напишите код, который выводит в консоль все уникальные слова из списка слов, в котором могут встречаться дубли.
        List<String> words = new ArrayList<>(List.of("orange", "apple", "pear", "apple", "banana",
                "pineapple", "peach", "orange", "melon", "apple", "pear"));
        task3(words);

//        Напишите код, который выводит в консоль все количество дублей из списка слов.
//        *Например, у вас есть текст из 6 слов, в котором есть одно слово, которое повторяется.
//        В таком случае в консоли выведется результат "2", то есть то количество элементов, которые повторяются.*
        task4(words);
    }

    private static void task1(List<Integer> list){
        for (Integer i:list) {
            System.out.print(i % 2 != 0 ? i + ", " : "" );
        }
        System.out.println();
    }
    private static void task2(List<Integer> list){
        Set<Integer> set = new HashSet<>(list);
        list = new ArrayList<>(set);
        list.sort(Integer::compareTo);
        for (Integer i:list) {
            System.out.print(i % 2 == 0 ? i + ", " : "" );
        }
        System.out.println();
    }
    private static void task3(List<String> list){
        Set<String> set = new HashSet<>(list);
        System.out.println(set);
    }
    private static void task4(List<String> list){
        HashMap<String, Integer> map = new HashMap<>();
        for (String s: list) {
            map.merge(s, 1, Integer::sum);
        }
        for (Map.Entry<String, Integer> e:map.entrySet()) {
            if (e.getValue() > 1) {
                System.out.print(e.getValue() + ", ");
            }
        }
        System.out.println();
    }
}