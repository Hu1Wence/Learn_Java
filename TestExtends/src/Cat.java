public class Cat extends Animal{
    public Cat(String name) {
        super(name);
    }

    @Override
    public void eat(String food) {
        System.out.println("我是一只猫");
        System.out.println(name + "正在吃" + food);
    }
}
