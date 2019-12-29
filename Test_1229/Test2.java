package Test_1229;

public class Test2 {
    //2. 创建多线程程序模拟买票业务，分别有 3 个买票的，和 2 个退票的
    private static volatile int ticket = 0;
    static class Buy implements Runnable {

        @Override
        public void run() {
            try {
                synchronized (Test2.class) {
                    while (ticket <= 0) {
                        Test2.class.wait();
                    }
                    ticket--;
                    Test2.class.notifyAll();
                    System.out.println(Thread.currentThread().getName() +
                            "购买了一张票,剩余票数: " + ticket);
                }
                Thread.sleep(2000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    static class Refund implements Runnable {
        @Override
        public void run() {
            try {
                synchronized (Test2.class) {
                    ticket++;
                    Test2.class.notifyAll();
                    System.out.println(Thread.currentThread().getName() +
                            "退了一张票,剩余票数: " + ticket);
                }
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 2; i++) {
            new Thread(new Buy()).start();
        }
        for (int i = 0; i < 3; i++) {
            new Thread(new Refund()).start();
        }
        Thread.sleep(1000);
    }
}
