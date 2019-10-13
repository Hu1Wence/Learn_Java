public class Bird extends Animal {

    public Bird(String name) {
        super(name);
    }

    @Override
    public void eat(String food) {
        System.out.println("我是一只鸟");
        System.out.println(name + " 正在吃 " + food);
    }
    public void fly() {
        System.out.println(name + "正在飞");
    }
}
