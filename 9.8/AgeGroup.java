public class AgeGroup {
    public static void main(String[] args) {
        int age = 100;
        if (age > 0 && age <= 18) {
            System.out.println("是少年");
        } else if (age >= 19 && age <= 28) {
            System.out.println("是青年");
        } else if (age >= 29 && age <= 55) {
            System.out.println("是中年");
        } else if (age >= 56) {
            System.out.println("是老年");
        } else {
            System.out.println("年龄有错!");
        }
    }
}