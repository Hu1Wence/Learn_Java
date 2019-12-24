package Test_1224;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorsTest {
    private static final ExecutorService EXE =
            Executors.newFixedThreadPool(5);

    public static void main(String[] args) {
      for (int i = 0; i<100;i++) {
          final int j = i;
          EXE.submit(new Runnable() {
              @Override
              public void run() {
                  while (true) {
                      System.out.println(j);
                      try {
                          Thread.sleep(3000);
                      } catch (InterruptedException e) {
                          e.printStackTrace();
                      }
                  }
              }
          });
      }
    }
}
