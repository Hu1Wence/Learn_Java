public class NumBit {
    public static void main(String[] args) {
        int num = 34;
        for (int i = 31; i >= 0; i--) {
            if (((num >> i) & 1) == 1) {
                System.out.print("1 ");
            } else {
                System.out.print("0 ");
            }
        }
    }
}