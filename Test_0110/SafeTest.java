package lesson2;

public class SafeTest {

    private static Integer COUNT;

    public synchronized static void increment(){
        COUNT++;
    }
//    public static void increment(){
//        synchronized (SafeTest.class){
//            COUNT++;
//        }
//    }
//    public synchronized void increment2(){
//        COUNT++;
//    }
//    public void increment2(){
//        synchronized(this){
//            COUNT++;
//        }
//    }

    public static synchronized void decrement(){
        COUNT--;
    }

    public static void main(String[] args) {
        Object o = new Object();
        Runnable r = new Runnable() {
            @Override
            public void run() {
                for(int j=0; j<10000; j++){
//                    synchronized (this){
//                        COUNT++;
//                    }
                    //不推荐使用Integer、String对象锁定：
                    //原因是常量池和堆中对象的不确定性
                    synchronized (COUNT){
                        COUNT++;
                    }
//                    increment();
                }
//                for(int j=0; j<10000; j++){
////                    synchronized (this){
////                        COUNT++;
////                    }
//                    decrement();
//                }
            }
        };
        for(int i=0; i<20; i++){
            new Thread(r).start();
        }
        //>1使用debug的方式启动
        while(Thread.activeCount()>1)
            Thread.yield();//当前线程让步，从运行态转变为就绪态
        System.out.println(COUNT);
    }
}
