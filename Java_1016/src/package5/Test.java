package package5;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        Student[] students = new Student[] {
                new Student("张三", 58),
                new Student("李四", 72),
                new Student("王五", 66),
                new Student("赵六", 98)
        };
        Arrays.sort(students);
        System.out.println(Arrays.toString(students));
    }
}
