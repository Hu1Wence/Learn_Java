package Test_1226;

import Test_1222.MyBlockingQueue;

public class MyThreadPool {

    private MyThread[] threads;
    private MyBlockingQueue<Runnable> workQueue;

    public MyThreadPool(int capacity, int size) {
        threads = new MyThread[capacity];
        workQueue = new MyBlockingQueue<>(size);
        for (int i = 0; i < capacity; i++) {
            threads[i] = new MyThread(workQueue);
            threads[i].start();
        }
    }

    public void execute(Runnable task) {
        try {
            workQueue.put(task);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static class MyThread extends Thread {

        private MyBlockingQueue<Runnable> workQueue;

        public MyThread(MyBlockingQueue<Runnable> workQueue) {
            this.workQueue = workQueue;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    Runnable task = workQueue.take();
                    task.run();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
