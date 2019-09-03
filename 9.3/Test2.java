public class Test2{
    public static void main(String[] args) {
        int num = 10;
        long num2 = 20;
        //等价于System.out.printf("num = %d", num);
        //java 中 int 固定为4个字节， long 固定为 8 个字节
        //java 中 int 为有符号整形
        System.out.println("num = " + num);
        System.out.println("num = " + num2);
        System.out.println("num = " + Integer.MAX_VALUE);
        System.out.println("num = " + Integer.MIN_VALUE);
    }
}