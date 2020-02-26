import java.io.InputStream;

public class Test {

    public static void main(String[] args) {
        InputStream is = Test.class.getClassLoader()
                .getResourceAsStream("/Users/huwence/Desktop/net-study/webapp/login.html" );
        System.out.println(is);
    }
}
