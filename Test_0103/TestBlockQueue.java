package Test_0103;

public class TestBlockQueue {
    private static String[] INFOS = {"A", "B", "C", "D"};

    private static int INDEX;

    private static class printTask implements Runnable {
        private Integer index;

        public printTask(Integer index) {
            this.index = index;
        }

        @Override
        public void run() {
            try {
                for (int k = 0; k < 10; k++) {
                    synchronized (INFOS) {
                        while (INDEX != index) {
                            INFOS.wait();
                        }
                        System.out.println(Thread.currentThread().getName() + INFOS[index]);
                        if (index == INFOS.length-1) {
                            System.out.println("===" + (k + 1));
                        }
                        INDEX = (INDEX + 1) % INFOS.length;
                        INFOS.notifyAll();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < INFOS.length; i++) {
            new Thread(new printTask(i)).start();
        }
    }
}

