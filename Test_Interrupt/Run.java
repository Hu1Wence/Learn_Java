package Test_Interrupt;

public class Run {
    public static void main(String[] args) {
        try {
            MyThread thread = new MyThread();
            thread.start();
            Thread.sleep(3000);
            thread.interrupt();
//            System.out.println("是否停止1? =" + thread.isInterrupted());
//            System.out.println("是否停止2? =" + thread.isInterrupted());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("end!");
    }
}
