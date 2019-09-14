public class RecursionTest {
    public static void main(String[] args) {
        //1.按顺序打印一个数字的每一位
        int num = 3234;
        Print(num);
        //2.递归求1 + 2 + 3 + ... + 10
        num = 10;
        int ret = Sum(num);
        System.out.println(ret);
        //3.输入一个非负整数，返回组成它的数字之和
        num = 4322;
        ret = SumPlus(num);
        System.out.println(ret);
        //4.求斐波那契数列的第N项
        num = 6;
        ret = Fib(num);
        System.out.println(ret);
    }
    public static void Print(int num) {
        if (num > 9) {
            Print(num / 10);
        }
        System.out.print(num % 10 + " ");
    }
    public static int Sum(int num) {
        if (num == 1) {
            return 1;
        }
        return num + Sum(num - 1);
    }
    public static int SumPlus(int num) {
        if (num < 10) {
            return num;
        }
        return num % 10 + SumPlus(num / 10);
    }
    public static int Fib(int num) {
        if (num == 1 || num == 2) {
            return 1;
        }
        return Fib(num - 1) + Fib(num - 2);
    }
}