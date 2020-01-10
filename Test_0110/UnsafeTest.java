package lesson2;

public class UnsafeTest {
    private static int COUNT;
    // 1. 初始化一个变量值=0；
    // 2. 启动20个线程，每个线程对这个值++，
    // 执行10000次
    public static void main(String[] args) {
        Object o = new Object();
        for(int i=0; i<20; i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for(int j=0; j<10000; j++){
                        synchronized (o){
                            COUNT++;
                        }
                    }
                }
            }).start();
        }
        //>1使用debug的方式启动
        while(Thread.activeCount()>1)
            Thread.yield();//当前线程让步，从运行态转变为就绪态
        System.out.println(COUNT);
    }
}
