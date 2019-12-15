package Test_1215;

public class InterruptTest {
    public static void main(String[] args) throws InterruptedException {
        //中断之后,执行异常处理,之后再次运行
//        Thread t = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                while (!Thread.interrupted()) {
//                    try {
//                        System.out.println(Thread.currentThread().getName());
//                        Thread.sleep(1000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        });
//        t.start();
//        Thread.sleep(5000);
//        t.interrupt();


        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (!Thread.currentThread().isInterrupted()) {
                    try {
                        System.out.println(Thread.currentThread().getName());
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        t2.start();
        Thread.sleep(5000);
        t2.interrupt();
    }
}
