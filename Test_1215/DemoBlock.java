package Test_1215;

public class DemoBlock implements Runnable {
    int num = 10;//票池
    public static void main(String[] args) {
        DemoBlock d = new DemoBlock();
        Thread t1 = new Thread(d, "线程一");
        Thread t2 = new Thread(d, "线程二");
        Thread t3 = new Thread(d, "线程三");
        Thread t4 = new Thread(d, "线程四");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }

    private synchronized void sell() { //线程同步
        if (num > 0) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("票数, " + num--);
        }
    }

    @Override
    public void run() {
        while (true) {
            sell();
        }
    }
}
