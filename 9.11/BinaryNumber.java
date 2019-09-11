public class BinaryNumber {
    public static void main(String[] args) {
        //首位为奇数位
        int num = 14;
        int check = 0;
        odd(num);
        System.out.println();
        even(num);
    }
    public static void odd(int num) {
        for (int i = 30; i >= 0; i = i - 2) {
            if ((num & (1 << i)) != 0) {
                System.out.print("1 ");
            } else {
            System.out.print("0 ");
            }
        }
    }
    public static void even(int num) {
        for (int i = 31; i >= 0; i = i - 2) {
            if ((num & (1 << i)) != 0) {
                System.out.print("1 ");
            } else {
                System.out.print("0 ");
            }
        }
    }
}