package package1;

public class Bird extends Animal {
    public Bird(String name) {
        super(name);
    }
    public void fly() {
        System.out.println(name + "正在飞");
    }

    @Override
    public void eat(String food) {
        super.eat(food);
        System.out.println("我是小鸟");
        System.out.println(name + "正在吃" + food);
    }
}
