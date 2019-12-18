package Test_1218;

class MyThread extends Thread {

    private int count = 5;

//    @Override
//    public void run() {
//        super.run();
//        count--;
//        System.out.println(Thread.currentThread().getName() + "计算 count = " + count);
//    }

    @Override
    synchronized public void run() {
        super.run();
        count--;
        System.out.println(Thread.currentThread().getName() + "计算 count = " + count);
    }
}

public class Test_Synchronized {
    public static void main(String[] args) throws InterruptedException {
        MyThread myThread = new MyThread();
        Thread threadA = new Thread(myThread, "threadA");
        Thread threadB = new Thread(myThread, "threadB");
        Thread threadC = new Thread(myThread, "threadC");
        Thread threadD = new Thread(myThread, "threadD");
        Thread threadE = new Thread(myThread, "threadE");
        threadA.start();
        threadB.start();
        threadC.start();
        threadD.start();;
        threadE.start();
    }
}
