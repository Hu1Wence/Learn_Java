public class IsPrime {
    public static void main(String[] args) {
        int num = 4;
        int i = 2;
        for (i = 2; i < num; i++) {
            if (num % i == 0) {
                System.out.println(num + " 不是素数");
                break;
            }
        }
        if (i == num) {
            System.out.println(num + " 是素数");
        } else if (num <= 1){
            System.out.println("您的数字有误!");
        }
    }
}