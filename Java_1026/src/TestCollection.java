import java.util.Map;
import java.util.HashMap;

public class TestCollection {
    public static void main(String[] args) {
//        //泛型语法，集合中保存的是 String 类型的若干对象
//        //本身是 ArrayList<String> 类型
//        Collection<String> collection = new ArrayList<>();
//        //使用isEmpty和size
//        System.out.println(collection.isEmpty());
//        System.out.println(collection.size());
//        //使用add
//        collection.add("张三");
//        collection.add("李四");
//        collection.add("王五");
//        System.out.println(collection.isEmpty());
//        System.out.println(collection.size());
//
//        //使用toArray
//        Object[] array =  collection.toArray();
//        System.out.println(Arrays.toString(array));
//
//        System.out.println("使用for each 遍历集合类");
//        for (String s: collection) {
//            System.out.println(s);
//        }
//
//        //使用 contains 方法
//        boolean ret =  collection.contains("李四");
//        System.out.println("ret = " + ret);
//
//        //删除方法
//        collection.remove("张三");
//        System.out.println(Arrays.toString(array));

        // Map 的基本用法
        Map<String, String> map = new HashMap<>();

        //使用 isEmpty 和 size
        System.out.println(map.isEmpty());
        System.out.println(map.size());

        //使用 put 插入键值对
        map.put("及时雨", "宋江");
        map.put("花和尚", "鲁智深");
        map.put("行者", "武松");
        //put 方法如果key已经存在，新的value会覆盖旧的value
        //map.put("行者", "武二郎");

        System.out.println(map.isEmpty());
        System.out.println(map.size());

        //使用 get 根据 key 查找 value
        System.out.println(map.get("行者"));

        //需要使用 Entry 来进行遍历，每个 Entry 就是一个"条例"。
        for (HashMap.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        //使用 containsKey 和 containsValue方法
        System.out.println(map.containsKey("及时雨"));
        System.out.println(map.containsValue("宋江"));

    }

}
