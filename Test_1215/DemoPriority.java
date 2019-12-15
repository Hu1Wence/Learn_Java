package Test_1215;

public class DemoPriority {
    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            MyThread t1 = new MyThread("加", "+");
            t1.setPriority(Thread.MIN_PRIORITY);
            MyThread t2 = new MyThread("减", "-");
            t2.setPriority(3);
            MyThread t3 = new MyThread("乘", "×");
            t3.setPriority(8);
            MyThread t4 = new MyThread("除", "÷");
            t4.setPriority(Thread.MAX_PRIORITY);
            t1.start();
            t2.start();
            t3.start();
            t4.start();
        }

    }
}

class MyThread extends Thread {
    String name;
    String output;

    public MyThread(String name, String output) {
        this.name = name;
        this.output = output;
    }

    @Override
    public void run() {
        System.out.println(name + ":" + output);
    }
}
