package Http_Study;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * http响应数据：
 * 1，构建response对象，将输出流设置到该对象属性
 * 2.把这个对象相关数据设置进去，包括响应，响应头，响应体
 * 3.调用刷新，输出流打印数据返回给客户端
 */

public class Response {

    private PrintWriter writer;

    //http版本号
    private String version = "HTTP/1.1";

    //状态码
    private int status;

    //状态码描述
    private String message;

    //响应头
    private Map<String, String> headers = new HashMap<>();

    //响应体
    private StringBuilder body = new StringBuilder();

    private Response() {

    }


    public static Response buildResponse(OutputStream outputStream) {
        Response response = new Response();
        response.writer = new PrintWriter(outputStream, true);


        return response;
    }

    /**
     * 添加响应头
     *
     * @param key
     * @param value
     */
    public void addHeader(String key, String value) {
        headers.put(key, value);
    }

    /**
     * 按行把请求体数据设置到body中
     *
     * @param line
     */
    public void println(String line) {
        body.append(line + "\n");
    }

    /**
     * 输出流打印并刷新相应数据，返回给客户端
     */
    public void flush() {
        //打印响应行
        writer.println(version + " " + status + " " + message);
        //打印响应头
        //设置响应格式Content-Type(浏览器获取相应数据以后，按照什么类型来渲染或处理数据)
        writer.println("Content-Type: text/html; charset=UTF-8");
        if (body.length() != 0) {
            writer.println("Content-Length: " + body.toString().getBytes().length);
        }
        //打印请求头
        for (Map.Entry<String, String> entry : headers.entrySet()) {
            writer.println(entry.getKey() + ":" + entry.getValue());
        }
        //打印空行
        writer.println();

        //打印响应体
        if (body.length() != 0) {
            writer.println(body);
        }

        //刷新输出流：1.初始化PrintWriter时， 第二个参数为true，设置自动刷新
        //2.printWriter.flush

    }

    /**
     * 构建200正常响应的响应行
     */
    public void build200() {
        status = 200;
        message = "ok";
    }

    public void build404() {
        status = 404;
        message = "Not Found";
    }

    public void build3xx() {
        status = 307;//301/302/307都可以
        message = "Redirect";
    }

    public void build405() {
        status = 405;
        message = "Method Not Allowed";
    }

    public void build500() {
        status = 500;
        message = "Internal Server Error";
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
