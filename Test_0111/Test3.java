package Test_0107;

public class Test3 {
    static class Fib implements Runnable {
        private volatile static int NUM;
        private volatile static int fib1 = 1;
        private volatile static int fib2 = 1;
        private volatile static int count = 2;
        public int result;

        public Fib(int NUM) {
            this.NUM = NUM;
        }

        @Override
        public void run() {
            if (NUM <= 2 && NUM >= 0) {
                result = 1;
                return;
            } else {
                while (count < NUM) {
                    synchronized (Fib.class) {
                        if (count < NUM) {
                            result = fib1 + fib2;
                            fib1 = fib2;
                            fib2 = result;
                            count++;
                        }
                    }
                }
            }
        }
    }

    //1 1 2 3 5 8
    public static void main(String[] args) {
        Fib task = new Fib(7);
        Thread a = new Thread(task, "A");
        Thread b = new Thread(task, "B");
        Thread c = new Thread(task, "C");
        a.start();
        b.start();
        c.start();
        while (Thread.activeCount() > 2) {
            ;
        }
        System.out.println(task.result);
    }
}
