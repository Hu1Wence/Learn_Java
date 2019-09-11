import java.util.Random;
import java.util.Scanner;

public class ToGuessNumber {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner sc = new Scanner(System.in);
        int answerNum = random.nextInt(100) + 1;
        System.out.println("请输入您猜的数字:");
        while(true) {
            int toGuess = sc.nextInt();
            if (toGuess > answerNum) {
                System.out.println("猜大了！");
            } else if (toGuess < answerNum) {
                System.out.println("猜小了！");
            } else {
                System.out.println("猜对了！");
                break;
            }
        }
        sc.close();
    }
}