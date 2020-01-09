import org.junit.Test;

import java.io.PrintWriter;
import java.io.StringWriter;

public class StringWriterTest {

    @Test
    public void t1(){
        int i = 0;
        try {
            if(i == 0)
                throw new RuntimeException();
        } catch (Exception e){
            // 异常打印输出到PrintWriter--->StringWriter
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            e.printStackTrace(pw);
            System.out.println(sw);
        }
    }
}
