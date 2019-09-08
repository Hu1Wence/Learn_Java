public class IsPrimePlus {
    public static void main(String[] args) {
        int isPrime = 0;
        int check = 0;
        for (isPrime = 1; isPrime <= 100; isPrime++) {
            for (check = 2; check < isPrime; check++) {
                //只要求模一次为 0 ,则这个数就肯定不是素数
                if (isPrime % check == 0) {
                    break;
                }
            }
            if (check == isPrime) {
                System.out.print(isPrime + " ");
            }
        }
    }
}