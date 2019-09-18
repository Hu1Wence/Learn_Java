public class JumpFloor {
    public static void main(String[] args) {
        int floor = 3;
        System.out.println(jumpFloor(floor));
    }
    public static int jumpFloor(int n) {
        if (n == 1 || n == 2) {
            return n;
        }
        return jumpFloor(n - 1) + jumpFloor(n - 2);
    }
}