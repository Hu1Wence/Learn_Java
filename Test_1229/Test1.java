package Test_1229;

public class Test1 {
    //1. 创建 5 个线程，分别计算从1到100万的相加
    static class MyThread extends Thread {
        @Override
        public void run() {
            int count = 0;
            while (true) {
                synchronized (MyThread.class) {
                    if (count < 1000000) {
                        count++;
                        System.out.println(Thread.currentThread().getName()
                                + " 使COUNT增加到: " + count);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Thread t1 = new MyThread();
        Thread t2 = new MyThread();
        Thread t3 = new MyThread();
        Thread t4 = new MyThread();
        Thread t5 = new MyThread();
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }
}
