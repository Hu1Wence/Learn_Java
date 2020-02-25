package Http_Study;

import java.io.File;
import java.io.IOException;
import java.net.Socket;

public class HttpTask implements Runnable {


    private Request request;

    private Response response;

    public HttpTask(Socket socket) {
        try {
            //通过客户端发送报文的输入流，创建http请求对象
            request = Request.buildRequest(socket.getInputStream());

            response = Response.buildResponse(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
            throw  new RuntimeException("客户端连接的IO流出错", e);
        }
    }

    @Override
    public void run() {
        //1.根据解析出的request对象属性，来进行逻辑处理

        response.setStatus(200);
        response.setMessage("ok");
        //改造：读取项目中的login.html文件内容，并返回给客户端

        response.println("正确响应了客户端的信息");
        response.flush();
    }
}
