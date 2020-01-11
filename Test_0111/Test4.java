package Test_0107;

import java.util.ArrayList;
import java.util.List;

public class Test4 {
    static class CountList<E> implements Runnable {
        List<E> list;
        public volatile static int COUNT;

        public CountList(List<E> list) {
            this.list = list;
        }

        @Override
        public void run() {
            while (!list.isEmpty()) {
                synchronized (CountList.class) {
                    if (!list.isEmpty()) {
                        list.remove(0);
                        COUNT++;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add(1);
        }
        CountList<Integer> list1 = new CountList<>(list);

        Thread a = new Thread(list1);
        Thread b = new Thread(list1);
        Thread c = new Thread(list1);
        a.start();
        b.start();
        c.start();
        while (Thread.activeCount() > 2) {

        }
        System.out.println(list1.COUNT);
    }
}
