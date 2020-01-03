package Test_0103;

public class Test_Add {
    private static  String[] print = {"A", "B", "C"};

    private static int INDEX;

    public static void main(String[] args) {
        for (int i = 0; i < print.length; i++) {
            final int j = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 10; i++) {
                        try {
                            synchronized (print) {
                                while (INDEX != j) {
                                    print.wait();
                                }
                                System.out.print(print[INDEX]);
                                if (j == print.length-1) {
                                    System.out.println();
                                }
                                INDEX = (INDEX + 1) % print.length;
                                print.notifyAll();
                            }
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();
        }
    }
}
