package Test_1226;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolTest {

    public static void main(String[] args) {
        //定制的线程池
        ThreadPoolExecutor executor
                = new ThreadPoolExecutor(1, 5,
                3, TimeUnit.SECONDS, new ArrayBlockingQueue(Integer.MAX_VALUE),
                new ThreadPoolExecutor.AbortPolicy());

//        //单线程池
//        Executors.newSingleThreadExecutor();
//        //固定数量线程池
//        Executors.newFixedThreadPool();
//        //可缓存线程池
//        Executors.newCachedThreadPool();
//        //定时任务的线程池
//        Executors.newScheduledThreadPool();
    }


}
