public class Test {
    public static void main(String[] args) {
        MyThread thread = new MyThread("我的线程");
        thread.start();
//        thread.run();
        System.out.println(Thread.currentThread().getName());

    }
}

class  MyThread extends Thread{
    public MyThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
//     while (true){}
    }


}
