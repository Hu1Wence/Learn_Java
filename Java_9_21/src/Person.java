import javax.print.attribute.standard.MediaSize;

public class Person {
    public String name;
    public String sex;
    public int age;
    public boolean isSingle;

    public Person(String name, String sex, int age, boolean isSingle) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.isSingle = isSingle;
    }
    public void eat() {
        System.out.println(name + sex + age + "正在吃饭");
    }
    public void sleep() {
        System.out.println(name + sex + age + "正在睡觉");
    }
    public void show() {
        System.out.println("我叫: " + name + " 年龄: " + "性别: " + sex + "是否单身: " + isSingle);
    }
}
