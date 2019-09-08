public class IsLeapYear {
    public static void main(String[] args) {
        int IsLeapYear = 0;
        for (IsLeapYear = 1000; IsLeapYear <= 2000; IsLeapYear++) {
            if (IsLeapYear % 4 == 0 && IsLeapYear % 100 != 0) {
                //判定普通闰年
                System.out.print(IsLeapYear + " ");
            } else if (IsLeapYear % 400 == 0) {
                //判定世纪闰年
                System.out.print(IsLeapYear + " ");
            }
        }
    }
}