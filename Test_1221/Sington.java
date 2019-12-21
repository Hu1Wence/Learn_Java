package Test_1221;

public class Sington {
    //单例模式
    //饿汉模式(在类加载时,直接对类变量进行初始化)
//    private static final Sington SINGTON = new Sington();
//
//    private Sington() {
//        //
//    }
//
//    public static Sington getInstance() {
//        return SINGTON;
//    }

    //懒汉模式(在类方法调用时,对类变量进行初始化)
    //单线程版
    private static Sington SINGTON = null;

    private Sington() {
        //
    }

    public static Sington getInstance() {
        if (SINGTON == null) {
            // new 对象不具有原子性
            // 1.分配内存空间
            // 2.初始化对象
            // 3.把对象赋值给变量引用
            // 执行指令重排序: 132
            SINGTON = new Sington();
        }
        return SINGTON;
    }


    public static void main(String[] args) {
        for (int i = 0; i < 10 ; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    Sington s = Sington.getInstance();
                }
            }).start();
        }
    }
}
