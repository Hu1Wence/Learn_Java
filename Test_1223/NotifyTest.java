package Test_1222;

public class NotifyTest {

    private static int COUNT;

    //生产者模式
    private static class Producer implements Runnable {
        @Override
        public void run() {
            try {
                for (int i = 0; i < 15; i++) {
                   synchronized (NotifyTest.class) {
                       while (COUNT + 3 > 100) {
                           NotifyTest.class.wait();
                       }
                       COUNT += 3;
                       NotifyTest.class.notifyAll();
                       System.out.println(Thread.currentThread().getName()
                               + "生产了面包,剩余:" + COUNT + "个");
                       Thread.sleep(3000);
                   }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static class Consumer implements Runnable {


        @Override
        public void run() {
            try {
                while (true) {
                    while (COUNT == 0) {
                        NotifyTest.class.wait();
                    }
                    COUNT -= 1;
                    NotifyTest.class.notifyAll();
                    System.out.println(Thread.currentThread().getName() +
                            "购买了面包,剩余:" + COUNT + "个");
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}