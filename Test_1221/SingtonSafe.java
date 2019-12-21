package Test_1221;

public class SingtonSafe {

    //懒汉模式(在类方法调用时,对类变量进行初始化)
    //多线程版
    private static volatile SingtonSafe SINGTONSAFE = null;

    private SingtonSafe() {
        //
    }

    //可以满足线程安全,但性能低效
//    public static synchronized SingtonSafe getInstance() {
//        if (SINGTONSAFE == null) {
//            SINGTONSAFE = new SingtonSafe();
//        }
//        return SINGTONSAFE;
//    }

    public static synchronized void test() {
        System.out.println("OK");//代码行y
        //同步静态方法锁的是类对象
        //锁的是当前类
    }

    public synchronized void test2() {
        System.out.println("OK");//代码行z
        //同步实例方法锁的是引用对象
        //锁的是this
    }

    //满足线程安全,性能高效
    //双重校验锁写法
    // synchronized 和 volatile 两个关键字保证单例模式的多线程安全问题
    // synchronized 单例模式下保证读写分离效率问题
    // volatile 单例模式下保证变量的高效问题
    //volatile 关键字:
    //1.禁止指令重排序:new操作会进行指令分解,但是不再重排序
    //2.可见性: 对 (1) 行代码,可见性得到保证,都是从主内存获取
    //3.volatile 关键字修饰的变量,所在代码行建立内存屏障,
    // 保证代码行不会排序到之后.之后的代码行不会排序到之前.
    public static synchronized SingtonSafe getInstance() {
        if (SINGTONSAFE == null) {
            synchronized (SingtonSafe.class) {
                if (SINGTONSAFE == null) {
                    // new 对象不具有原子性
                    // 1.分配内存空间
                    // 2.初始化对象
                    // 3.把对象赋值给变量引用
                    // 执行指令重排序: 132
                    SINGTONSAFE = new SingtonSafe();//代码行x
                }
            }
        }
        return SINGTONSAFE;
    }
}
