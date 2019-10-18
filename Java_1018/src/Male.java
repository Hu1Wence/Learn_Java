public class Male extends People implements IJumping , IPlayingBall{

    public Male(String name, String sex) {
        super(name, sex);
    }

    @Override
    public void jump() {
        System.out.println("一个" + sex + "人" + "叫" + name + " 正在跳");
    }

    @Override
    public void playBall() {
        System.out.println("一个" + sex + "人" + "叫" + name + " 正在打篮球");
    }
}
