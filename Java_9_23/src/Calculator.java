public class Calculator {
    public double num1;
    public double num2;

    //实现加法
    public void add () {
        System.out.println(num1 + " + " + num2 + " = " + (num1 + num2));
    }

    //实现减法
    public void sub() {
        System.out.println(num1 + " - " + num2 + " = " + (num1 - num2));
    }

    //实现乘法
    public void mul() {
        System.out.println(num1 + " * " + num2 + " = " + (num1 * num2));
    }

    //实现除法
    public void div() {
        double num1 = this.num1;
        double num2 = this.num2;
        System.out.println(num1 + " / " + num2 + " = " + (num1 / num2));
    }
}
