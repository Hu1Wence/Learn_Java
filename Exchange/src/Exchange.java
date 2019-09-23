public class Exchange {
    public double num1;
    public double num2;

    //实现交换两个数的值
    public void exchange() {
        double temp = num1;
        num1 = num2;
        num2 = temp;
        System.out.printf("交换的值为 num1 = %f, num2 = %f", num1, num2);
    }
}
