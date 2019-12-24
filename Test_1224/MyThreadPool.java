package Test_1224;

import Test_1222.MyBlockingQueue;

public class MyThreadPool {

    private MyBlockingQueue<Runnable> queue;

    private MyWorker[] workers;

    public MyThreadPool(int capacity, int size) {
        workers = new MyWorker[capacity];
        queue = new MyBlockingQueue<>(size);
        for (int i = 0; i < capacity; i++) {
            workers[i] = new MyWorker(queue);
            workers[i].start();
        }
    }

    public void execute(Runnable task) throws InterruptedException {
        queue.put(task);
    }
}

class MyWorker extends Thread {

    private MyBlockingQueue<Runnable> queue;

    public MyWorker(MyBlockingQueue<Runnable> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Runnable task = queue.take();
                task.run();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}