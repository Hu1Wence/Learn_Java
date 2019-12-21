package Test_1221;

public class NotifyTest {
    public static void main(String[] args) {
        Thread t1 =  new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    // (1) 对 NotifyTest.class 加锁
                    synchronized (NotifyTest.class) {
                        System.out.println("t1");
                        Thread.sleep(1000);
                        // (2) t1 线程阻塞,释放 NotifyTest.class对象锁
                        NotifyTest.class.wait();
//                        this.wait();//只会释放当前对象的锁
                        System.out.println("t1 wait finish");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread t2 =  new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    // (3) 竞争 NotifyTest.class 对象锁
                    synchronized (NotifyTest.class) {
                        // (4) 通知 NotifyTest.class 对象,
                        // 所有竞争该对象锁的进程都可以来竞争
                        //通知是在当前  NotifyTest.class.notify() 代码块结束后
                        //通知所有因为  NotifyTest.class.wait()
                        // 和 synchronized 阻塞的线程,都可以来竞争

                        NotifyTest.class.notify();
                        System.out.println("t2");
                        Thread.sleep(1000);
                        System.out.println("t2 wait finish");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t1.start();
        t2.start();
    }
}
