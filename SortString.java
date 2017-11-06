import java.util.Arrays;
import java.util.Collections;

public class SortString {
    /* Сортировка строк стандартными методами java.util */
    public static void main(String[] args) {
        String[] names = new String[] {"Роман","Анна", "Василий", "Евгения","Наталья"};
        System.out.println("Есть массив");
        System.out.println(Arrays.toString(names));
        System.out.println();
        System.out.println("Отсортировали по алфавиту");
        names=sortString(names);
        System.out.println(Arrays.toString(names));
        System.out.println();
        System.out.println("Отсортировали в обратном порядке по алфавиту");
        names=sortStringReversion(names);
        System.out.println(Arrays.toString(names));
    }

    public static String[] sortString(String[] strArray) {
               Arrays.sort(strArray);
               return strArray;
    }
    public static String[] sortStringReversion(String[] strArray) {
        Arrays.sort(strArray, Collections.reverseOrder());
        return strArray;
    }
}