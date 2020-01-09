import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SerializableTest {

    @Test
    public void t1() throws Exception {
        Person1 old1 = new Person1("张三", 11);
        Person1 old2 = new Person1("李四", 12);
        Person1Container container = new Person1Container();
        container.name = "abc";
        //添加到一个list中
        container.person1s.add(old1);
        container.person1s.add(old2);
        // 深拷贝
//        Person1Container clone = (Person1Container) container.clone();
        //字节数组输入输出流+对象输入输出流
        // 序列化对象--->将对象（序列化）到字节数组输出流
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(container);

        // 反序列化对象--->将字节数组输出流中的对象（反序列化）
        ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bais);
        Person1Container clone = (Person1Container) ois.readObject();

        //张三的年龄修改为13
        container.name = "efg";
        container.person1s.get(0).age = 13;

        System.out.println(container.name+"\n"+container.person1s);
        //clone.person1s是复制的container.person1s的引用
        System.out.println(clone.name+"\n"+clone.person1s);
    }

    public static class Person1Container implements Serializable{
        private static final long serialVersionUID = 1L;
        private String name;
        private List<Person1> person1s = new ArrayList<>();
    }

    /**
     * 做Java对象的序列化，需要实现Serializable接口
     */
    public static class Person1 implements Serializable {
        private static final long serialVersionUID = 1L;
        private String name;
        private Integer age;

        public Person1(String name, Integer age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Person1{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}
