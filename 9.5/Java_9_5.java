public class Java_9_5 {
    public static void main(String[] args) {
        int a = 40;
        int b = 20;
        // 方法一：
        int num = 0;
        num = a;
        a = b;
        b = num;
        // 方法二:
        // a = a + b;
        // b = a - b;
        // a = a - b;
        // 方法三:
        // a = a ^ b;
        // b = a ^ b;
        // a = a ^ b;
        System.out.println(a);
        System.out.println(b);
    }
}