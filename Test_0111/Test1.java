package Test_0107;

public class Test1 {
    static class Add implements Runnable {
        private volatile static int count = 0;

        @Override
        public void run() {
            while (count < 1000000) {
                synchronized (Add.class) {
                    if (count < 1000000) {
                        count++;
                        System.out.println(Thread.currentThread().getName() +
                                "修改count:" + count);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Runnable add = new Add();
        Thread a = new Thread(add, "A");
        Thread b = new Thread(add, "B");
        Thread c = new Thread(add, "C");
        Thread d = new Thread(add, "D");
        a.start();
        b.start();
        c.start();
        d.start();

    }
}
