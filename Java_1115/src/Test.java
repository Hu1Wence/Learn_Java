import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Test {
    public static void main(String[] args) {
        Collection collection = new ArrayList();
        collection.add(9527);
        collection.add("hello world");
        collection.add(new Object());
        collection.add(null);

        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            Object object = iterator.next();
            System.out.println(object);
        }

    }
}
