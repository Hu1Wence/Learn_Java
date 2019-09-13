import java.util.Scanner;

public class AddNum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i = 0;
        while ( i < 4) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = Add(a, b);
            System.out.println(a + " + " + b + " = " + c);
            i++;
        }
        sc.close();
    }
    public static int Add(int a, int b) {
        return a + b;
    }
}