import java.util.*;

public class Test {
    public static void main(String[] args) {
//        Collection<String> list = new ArrayList<>();
//        System.out.println(list.size());
//        System.out.println(list.isEmpty());
//        list.add("我");
//        list.add("爱");
//        list.add("Java");
//        System.out.println(list.size());
//        System.out.println(list.isEmpty());
//        Object[] array = list.toArray();
//        System.out.println(Arrays.toString(array));
//        for (String s : list) {
//            System.out.println(s);
//        }
//        list.remove("爱");
//        for (String s : list) {
//            System.out.println(s);
//        }
//        list.clear();
//        System.out.println(list.size());
//        System.out.println(list.isEmpty());
        Map<String, String> map = new HashMap<>();
        System.out.println(map.size());
        System.out.println(map.isEmpty());
        System.out.println(map.get("作者"));
        System.out.println(map.getOrDefault("作者", "佚名"));
        System.out.println(map.containsKey("作者"));;
        System.out.println(map.containsValue("佚名"));;
        map.put("作者", "鲁迅");
        map.put("标题", "狂人日记");
        map.put("发表时间", "1918年");
        System.out.println(map.size());
        System.out.println(map.isEmpty());
        System.out.println(map.get("作者"));
        System.out.println(map.getOrDefault("作者", "佚名"));;
        System.out.println(map.containsKey("作者"));;
        System.out.println(map.containsValue("佚名"));;
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
    }

}
