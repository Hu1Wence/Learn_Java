package lesson2;

public class InterruptTest {

    public static void explain(){
        // 标志位IS_INTERRUPTED=false;
        Thread t = new Thread();

        // interrupt()线程中断操作：
        // 1. IS_INTERRUPTED = true;
        // 2.如果线程处于调用wait()/join()/sleep()造成阻塞状态，
        // 就直接抛出InterruptedException异常
        // 3.抛出异常以后，IS_INTERRUPTED=false
        t.interrupt();

        // 返回中断标志位
        // return IS_INTERRUPTED;
        t.isInterrupted();

        // 返回当前线程中断标志位，并重置标志位
        // return IS_INTERRUPTED; IS_INTERRUPTED = false;
        boolean interrupted = Thread.interrupted();
    }

    public static void main(String[] args) throws InterruptedException {
        ignoreInterrupt();
        interruptQuit();
    }

    // 中断以后，执行异常处理逻辑，之后再次执行
    public static void ignoreInterrupt() throws InterruptedException {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                //isInterrupted=false;
                // ——>main()没有sleep修改为true
                while (!Thread.interrupted()){
//                while(!Thread.currentThread().isInterrupted()) {
                    //——>main()有sleep修改为true
                    try {
                        System.out.println(Thread.currentThread().getName());
                        //抛出异常
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        //isInterrupted=false;
                        e.printStackTrace();
                    }
                }
            }
        });
        t.start();
        Thread.sleep(3000);
        t.interrupt();
    }

    //中断线程以后退出
    public static void interruptQuit() throws InterruptedException {
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while(!Thread.currentThread().isInterrupted()) {
                        System.out.println(Thread.currentThread().getName());
                        //抛出异常
                        Thread.sleep(1000);
                    }
                } catch (InterruptedException e) {
                    //isInterrupted=false;
                    e.printStackTrace();
                }
            }
        });
        t2.start();
        Thread.sleep(3000);
        t2.interrupt();
    }
}
