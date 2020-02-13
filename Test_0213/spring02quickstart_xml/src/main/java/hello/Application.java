package hello;

public class Application {
    public static void main(String[] args) {
        System.out.println("application");

        MessagePrinter printer = new MessagePrinter();
        MessageService service = new MessageService();
        printer.setService(service);
        printer.printMessage();
    }
}
