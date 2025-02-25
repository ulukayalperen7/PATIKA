
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(3);
        list.add(21);
        list.add(42);
        list.add(444);
        list.add(33);
        list.add(70);    
         
        // Stream API ler collections üzerinde lambda ifadeler kullanarak işlem yapmamızı saglar 

        //list.stream().forEach(i -> System.out.println(i));
        list.forEach(i -> System.out.println(i));
        System.out.println();

        list.stream().filter(num -> num > 60).forEach(i -> System.out.println(i));

        list.stream().distinct().forEach(i -> System.out.println(i));

    }
}
