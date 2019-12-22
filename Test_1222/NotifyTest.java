package Test_1222;

public class NotifyTest {

    private static int COUNT;

    public static void main(String[] args) throws InterruptedException {
        // 10个生产者，每次生产3个
        // 无限个消费者，每次消费1个
        // COUNT范围是0-100
        for (int i = 0; i < 10; i++) {
            new Thread(new Producer()).start();
        }
        for (int i = 0; i < 100; i++) {
            new Thread(new Consumer()).start();
        }
    }

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
                        System.out.println(Thread.currentThread().getName() + "生产了面包，剩余：" + COUNT + "个");
                        Thread.sleep(1000);
                    }
                    Thread.sleep(1000);//释放锁以后，自己先不竞争
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
                    synchronized (NotifyTest.class) {
                        while (COUNT == 0) {//消费者A
                            /**
                             * 1.A等待 COUNT=0
                             * 2.生产了3个
                             * 3.三个消费者消费了
                             * 4.A竞争成功
                             */
                            NotifyTest.class.wait();
                        }
                        COUNT -= 1;
                        NotifyTest.class.notifyAll();
                        System.out.println(Thread.currentThread().getName() + "消费了面包，剩余：" + COUNT + "个");
                        Thread.sleep(100);
                    }
                    Thread.sleep(100);//释放锁以后，自己先不竞争
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
