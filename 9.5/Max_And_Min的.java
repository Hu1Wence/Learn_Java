public class Max_And_Min {
    public static void main(String[] args) {
        int a = 6;
        int b = 25;
        int c = 10;
        int num = 0;
        if (a < b) {
            num = b;
            b = a;
            a = num;
        }
        if (a < c) {
            num = c;
            c = a;
            a = num;
        }
        if (b < c) {
            num = c;
            c = b;
            b = num;
        }
        System.out.println("Max = " + a);
        System.out.println("Min = " + c);
    }
}