public class RecursionAdd_1{
    public static void main(String[] args) {
        int num = 1997;
        System.out.println(recursionAdd(num));
    }
    public static int recursionAdd(int num) {
        if (num < 10) {
            return num;
        }
        return num % 10 + recursionAdd(num / 10);
    }
}