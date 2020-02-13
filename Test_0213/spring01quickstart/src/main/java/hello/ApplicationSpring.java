package hello;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
public class ApplicationSpring {
    public static void main(String[] args) {
        System.out.println("applicationSpring");
//
//        MessagePrinter printer = new MessagePrinter();
//        MessageService service = new MessageService();
//        printer.setService(service);
//        printer.printMessage();

        //初始化Spring容器
        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationSpring.class);

        MessagePrinter printer = context.getBean(MessagePrinter.class);
        //MessageService service = context.getBean(MessageService.class);

//        System.out.println(printer);
//        System.out.println(service);

        //printer.setService(service);
        printer.printMessage();
    }
}
