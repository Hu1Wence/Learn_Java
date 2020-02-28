import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            int count = 0;
            int i = 0;
            String str = sc.nextLine();
            StringBuilder sb = new StringBuilder();
            while (i < str.length()) {
                sb.append(str.charAt(i));
                count++;
                int cur = i;
                cur++;
                while (cur < str.length()) {
                    if (sb.append(str.charAt(cur)).toString().equals(new StringBuilder(sb).reverse().toString())) {
                        count++;
                    }
                    cur++;
                }
                sb.delete(0, cur - i);
                i++;
            }
            System.out.println(count);
        }
    }
}
