package Test_Interrupt;

public class MyThread extends Thread {

    @Override
    public void run() {
        super.run();
        try {
            for (int i = 0; i < 10000000; i++) {
                if (interrupted()) {
                    System.out.println("已经是停止状态了!我要退出了!");
                    throw new InterruptedException();
                }
                System.out.println("i=" + (i + 1));
            }
        } catch (InterruptedException e) {
            System.out.println("进入MyThead.java类run方法中的catch了");
            e.printStackTrace();
        }
    }
}
