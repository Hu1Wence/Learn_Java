public class Java_9_6 {
    public static void main(String[] args) {
        // int num1 = 10;
        // long num2 = 20L;
        // num1 = num2; 这样就是错的
        // 只能将范围小的赋值给范围大的，否则将编译出错
        // num2 = num1;
        // System.out.println(num2);
        byte a = 10;
        byte b = 20;
        // byte c = a + b;
        // 这样会编译出错，a + b 会隐式转换成 int 类型,再将 int 转换成 byte 类型就会出错
        // System.out.println(c);
    }
}