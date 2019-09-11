public class Counting9 {
    public static void main(String[] args) {
        int num = 0;
        int count = 0;
        for (num = 1; num <= 100; num++) {
            if (num % 10 == 9) {
                count++;
            } 
            if (num / 10 == 9) {
                ++count;
            }
        }
        System.out.println(count);
    }
}