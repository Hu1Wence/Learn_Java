public class Female extends People implements  ISinging{

    public Female(String name, String sex) {
        super(name, sex);
    }

    @Override
    public void sing() {
        System.out.println("一个" + sex + "人" + "叫" + name + " 正在唱");

    }

    @Override
    public void rap() {
        System.out.println("一个" + sex + "人" + "叫" + name + " 正在说rap");
    }
}
