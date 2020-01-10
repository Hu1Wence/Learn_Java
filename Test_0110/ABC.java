package lesson2;

public class ABC {
    public static void main(String[] args) throws InterruptedException {
        Thread a = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("A");
            }
        });

        Thread b = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    a.join();
                    System.out.println("B");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread c = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    b.join();
                    System.out.println("C");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        c.start();
        b.start();
        a.start();
    }
}
