package Test_1215;

public class TestThread {

    public static void main(String[] args) {
        Thread a = new ThreadA();
        a.start();
        Thread b = new ThreadB();
        b.start();
    }
}
class ThreadA extends  Thread {
    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            System.out.println(i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
class ThreadB extends  Thread {
    @Override
    public void run() {
        for (char i = 'a'; i <= 'z'; i++) {
            System.out.println(i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
