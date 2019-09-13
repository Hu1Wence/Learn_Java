public class Number {
    public static void main(String[] args) {
        int num = 123;
        Print(num);
    }
    public static void Print(int num) {
        if (num > 9) {
            Print(num / 10);
        }
        System.out.print(num % 10 + " ");     
    }
}