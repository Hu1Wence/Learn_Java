package Test_1222;

public class SequencePrint2 {

    // 定义需要顺序打印的数据
    private static String[] INFOS = {"A","B","C","D"};

    // 当前执行到循环数组的索引
    private static int INDEX;

    public static void main(String[] args) {
        for(int i=0; i<INFOS.length; i++){
            new Thread(new PrintTask(i)).start();
        }
    }
    private static class PrintTask implements Runnable{

        // 当前线程需要执行的索引位置
        private Integer index;

        public PrintTask(Integer index){
            this.index = index;
        }

        @Override
        public void run() {
            try {
                for(int k=0; k<10; k++){
                    synchronized (INFOS){
                        // 如果需要打印的索引不等于当前线程的索引，就等待
                        while (INDEX != index){
                            INFOS.wait();
                        }
                        System.out.print(INFOS[index]);
                        if(index == INFOS.length-1){
                            System.out.println("==="+k);
                        }
                        // 索引+1，是循环队列的方式增加
                        INDEX = (INDEX+1)%INFOS.length;
                        INFOS.notifyAll();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
