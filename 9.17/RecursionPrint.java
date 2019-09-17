public class RecursionPrint{
    public static void main(String[] args) {
        int num = 1234;
        recursionPrint(num);
    }
    public static void recursionPrint(int num) {
        if (num > 9) {
            recursionPrint(num / 10);           
        }
        System.out.print(num % 10 + " ");
    }
}