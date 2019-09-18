public class Fib {
    public static void main(String[] args) {
        int num = 7;
        System.out.println(fib(num));
    }
    public static int fib(int num) {
        if (num == 1 || num == 2) {
            return 1;
        }
        return fib(num - 1) + fib(num - 2);
    }
}