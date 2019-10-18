public class Test {
    public static void main(String[] args) {
        Male male = new Male("蔡徐坤", "男");
        Female female = new Female("娃娃", "女");
        motion(male);
        female.rap();
    }
    public static void motion(IPlayingBall iPlayingBall) {
        System.out.println("我有一个小伙伴");
        iPlayingBall.playBall();
    }
}
