package Test_0107;

public class Test2 {

    private static int TICKET = 0;

    //退票者
    static class Refund implements Runnable {
        @Override
        public void run() {
            try {
                synchronized (Test2.class) {
                    TICKET++;
                    System.out.println(Thread.currentThread().getName()
                            + "退了一张票,当前票数为:" + TICKET);
                    Test2.class.notifyAll();
                }
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    //买票者
    static class Buy implements Runnable {
        @Override
        public void run() {
            try {
                synchronized (Test2.class) {
                    while (TICKET <= 0) {
                        Test2.class.wait();
                    }
                    TICKET--;
                    Test2.class.notifyAll();
                    System.out.println(Thread.currentThread().getName()
                            + "购买了一张票,当前票数:" + TICKET);
                }
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            new Thread(new Buy()).start();
        }
        for (int i = 0; i < 2; i++) {
            new Thread(new Refund()).start();
        }


    }
}
