package Test_1229;

import java.util.Scanner;

public class Test3 implements Runnable {
    //编写多线程，实现根据用户的输入，计算斐波那契数列数列
    private static volatile long FIB1 = 1;
    private static volatile long  FIB2 = 1;
    private static volatile long FIB3;
    private static volatile int COUNT = 0;
    @Override
    public void run() {
        synchronized (Test3.class) {
            FIB3 = FIB1 + FIB2;
            FIB1 = FIB2;
            FIB2 = FIB3;
            COUNT++;
            System.out.println(Thread.currentThread().getName()
                    + "计算FIB数为:" + FIB3);
        }
    }

    public static void main(String[] args) throws InterruptedException {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("请输入要求第几个斐波那契数");
        int num = 9;


        for (int i = 0; i < 3; i++) {
            new Thread(new Test3()).start();
        }
        while (Thread.activeCount() > 2) {
        }
        System.out.println("最终结果为:" + FIB3);
    }
}
