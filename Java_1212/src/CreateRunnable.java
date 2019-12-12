public class CreateRunnable {
    public static void main(String[] args) {
        Thread thread = new Thread(new MyRunnable());
        thread.setName("MuRunnable");
        thread.start();
        System.out.println(Thread.currentThread().getName());

    }

}

class MyRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }

}