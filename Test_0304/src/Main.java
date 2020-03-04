import java.util.HashSet;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String str = sc.nextLine();
            String remove = sc.nextLine();

            HashSet<Character> hashSet = new HashSet<>();
            for (int i = 0; i < remove.length(); i++) {
                hashSet.add(remove.charAt(i));
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < str.length(); i++) {
                if (!hashSet.contains(str.charAt(i))){
                    sb.append(str.charAt(i));
                }
            }
            System.out.println(sb.toString());
        }
    }
}
