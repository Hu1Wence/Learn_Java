import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("C 语言");
        list.add("Java");
        list.add("C++");
        list.add("Python");
        System.out.println(list);
        System.out.println(list.get(0));
        list.set(0, "PHP");
        System.out.println(list);
        List<String> list1 = new ArrayList<>(list);
        list1.subList(1, 3);
        System.out.println(list1);
    }
}
