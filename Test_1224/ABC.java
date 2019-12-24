package Test_1224;

public class ABC {
    private static String[] STR = {"A", "B", "C"};

    private static int INDEX;

    public static void main(String[] args) {
        for (int i = 0; i < STR.length; i++) {
            final int j = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int k = 0; k < 10; k++) {
                        try {
                            synchronized (STR) {
                                while (INDEX != j) {
                                    STR.wait();
                                }
                                System.out.print(STR[INDEX]);
                                if (j == STR.length - 1) {
                                    System.out.println();
                                }
                                INDEX = (INDEX + 1) % STR.length;
                                STR.notifyAll();
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
