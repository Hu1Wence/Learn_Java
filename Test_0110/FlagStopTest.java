package lesson2;

public class FlagStopTest {
    private static boolean IS_INTERRUPTED = false;
    public static void main(String[] args) throws InterruptedException {

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while(!IS_INTERRUPTED){
                        System.out.println(Thread.currentThread().getName());
                        Thread.sleep(1000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        Thread.sleep(3000);
        IS_INTERRUPTED =true;
    }
}
