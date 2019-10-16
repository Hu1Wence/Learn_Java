package package4;

public class Test {
    public static void main(String[] args) {
        Cat cat = new Cat("小猫");
        walk(cat);
        Duck duck = new Duck("小鸭子");
        swim(duck);
    }
    public static void walk(IRunning running) {
        System.out.println("我带小伙伴散步");
        running.run();
    }
    public static void swim(ISwimming swimming) {
        System.out.println("我带小伙伴游泳");
        swimming.swim();
    }
}
