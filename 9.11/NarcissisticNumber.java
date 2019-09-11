public class NarcissisticNumber {
    public static void main(String[] args) {
        int num = 0;
        for (num = 0; num <= 999; num++) {
            //个位
            int a = num % 10;
            //十位
            int b = (num / 10) % 10;
            //百位
            int c = (num / 100) % 10;
            if ((a * a * a) + (b * b * b) + (c * c * c) == num) {
                System.out.println(num);
            } 
        }
    }
}