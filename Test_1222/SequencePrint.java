package Test_1222;

public class SequencePrint {

    private static class ThreadA implements Runnable {
        @Override
        public void run() {
            synchronized (SequencePrint.class) {
                System.out.print("A");
            }
        }
    }

    private static class ThreadB implements Runnable {
        @Override
        public void run() {
            synchronized (SequencePrint.class) {
                System.out.print("B");
            }
        }
    }

    private static class ThreadC implements Runnable {
        @Override
        public void run() {
            synchronized (SequencePrint.class) {
                System.out.print("C");
            }
        }
    }

    public static void main(String[] args) {
        Thread threadA = new Thread(new ThreadA());
        Thread threadB = new Thread(new ThreadB());
        Thread threadC = new Thread(new ThreadC());
        threadA.start();
        threadB.start();
        threadC.start();
        for (int i = 0; i < 10; i++) {

            threadA.start();
            threadB.start();
            threadC.start();
        }
    }
}
