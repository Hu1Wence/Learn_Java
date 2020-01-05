package Test_0105;

class MyTask implements Runnable{

    public volatile static int count = 0;
    @Override

    synchronized public void run() {
        //执行业务逻辑
            count++;
            System.out.println(Thread.currentThread().getName() + "计算count :" + count);
    }



}



public class MyThread extends Thread {

    private boolean shouldStopFlag=false;

    private long checkIntervalTime;

    public MyThread(long checkIntervalTimeIn){

        this.checkIntervalTime=checkIntervalTimeIn;

    }

    public void run() {

        while(!shouldStopFlag){

            //如果获取不到.线程等待指定的时间间隔后，再去获取执行任务

            Runnable nexRunnable=getNextTask();

            if(nexRunnable!=null){

                nexRunnable.run();

            }else{

                try {

                    Thread.sleep(checkIntervalTime);

                } catch (InterruptedException e) {
                    e.printStackTrace();

                }

            }
        }

    }



    private Runnable getNextTask(){
        MyTask myTask = new MyTask();
        //获取下一个需要至执行的任务，可以队列等数据结合中获取
        if (myTask.count < 1000000) {
            return myTask;
        }

        return null;

    }

    public static void main(String[] args) {
        MyThread myThread = new MyThread(1);
        Thread a = new Thread(myThread, "A");
        Thread b = new Thread(myThread, "B");
        Thread c = new Thread(myThread, "C");
            a.start();
            b.start();
            c.start();
    }
}