public class Person {
    public String name;
    public String sex;
    public int age;

    public Person(String name, String sex, int age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    public void show() {
        System.out.println("我叫: " + name + " 性别: " + sex + " 年龄: " + age);
    }
    public void eat() {
        System.out.println(name + "在吃饭");
    }
    public void sleep() {
        System.out.println(name + "在睡觉");
    }
}
