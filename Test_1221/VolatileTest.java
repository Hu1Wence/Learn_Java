package Test_1221;

public class VolatileTest {
    private static volatile int N;

    private static synchronized void increment() {
        N++;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 100; j++) {
//                        increment();
                        synchronized (VolatileTest.class) {
                            N++;
                        }
                        if (N == 100) {
                            System.out.println("===" + N);
                        }
                    }
                }
            }).start();
        }
        while (Thread.activeCount() > 1) {
            Thread.yield();
        }
        System.out.println(N);
    }
}
