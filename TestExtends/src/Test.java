public class Test {
    public static void main(String[] args) {
//        Animal animal = new Animal("小动物");
//        Bird bird = new Bird("圆圆");
//        animal.eat("鱼");
//        bird.eat("谷子");
        Animal animal1 = new Animal("圆圆");
        Animal animal2 = new Bird("扁扁");
        Bird bird = new Bird("小鸟");
        animal1.eat("谷子");
        animal2.eat("谷子");
        bird.fly();
    }
}
