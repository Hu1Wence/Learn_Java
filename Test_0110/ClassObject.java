package lesson2;

public class ClassObject {

    public static void main(String[] args) {
        // 类也是java中的对象
        Class<ClassObject> classObjectClass = ClassObject.class;
        ClassObject object = new ClassObject();
        Class classObjectClass2 = object.getClass();
    }
}
