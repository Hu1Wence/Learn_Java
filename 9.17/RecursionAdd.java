public class RecursionAdd {
    public static void main(String[] args) {
        int num = 10;
        System.out.println(recursionAdd(num));
    }
    public static int recursionAdd(int num) {
        if (num == 1) {
            return 1;
        }
        return num + recursionAdd(num - 1);
    }
}