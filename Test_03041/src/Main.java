import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            int num = sc.nextInt();
            System.out.println(Buy(num));
        }
    }
    public static int Buy(int num) {
        for (int i = 0; i < 17; i++) {
            for (int j = 0; j < 12; j++) {
                if (i *  6 + j * 8 == num) {
                    return i + j;
                }
            }
        }
        return -1;
    }
}

