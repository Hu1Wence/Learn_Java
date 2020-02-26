package Http_Study;

import java.io.*;
import java.net.Socket;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class HttpTask implements Runnable {


    private Request request;

    private Response response;

    //保存session的数据结构:还可以保存在其他地方，如redis中间键
    private static ConcurrentMap<String, String> SESSION = new ConcurrentHashMap<>();

    public HttpTask(Socket socket) {
        try {
            //通过客户端发送报文的输入流，创建http请求对象
            request = Request.buildRequest(socket.getInputStream());

            response = Response.buildResponse(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("客户端连接的IO流出错", e);
        }
    }

    @Override
    public void run() {
        try {
            //1.根据解析出的request对象属性，来进行逻辑处理
            //2.在不同逻辑中将要返回的数据设置到response对象中
            //3.刷新响应信息，返回给客户端
            if ("/".equals(request.getUrl())) {
                response.build200();
                response.println("<h2>Http服务器首页</h2>");
                return;
            }

            //调整业务逻辑
            //1.根据url在webapp文件夹下去找是否存在资源，如果存在，就返回该资源内容

            InputStream is = this.getClass().getClassLoader()
                    .getResourceAsStream("." + request.getUrl());
            if (is != null) {
                BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
                String content;
                while ((content = br.readLine()) != null) {
                    response.println(content);
                }
                response.build200();
            } else if ("/login".equals(request.getUrl())) {
                //1.只接受post请求方法，否则返回405
                if (!"post".equalsIgnoreCase(request.getMethod())) {
                    response.build405();
                    response.println("不支持的请求方法" + request.getMethod());
                } else {
                    //2.校验用户名密码，校验通过返回
                    response.build200();
                    response.println("请求的数据：username=" + request.getParameter("username")
                            + ", password=" + request.getParameter("password"));
                    //session:将用户信息保存到服务器，并返回给客户端
                    String sessionId = UUID.randomUUID().toString();
                    SESSION.put(sessionId, request.getParameter("username")
                            + "," + request.getParameter("password"));
//                    response.addHeader("SESSIONID", sessionId);
                    response.addHeader("Set-Cookie", sessionId);

                }

            } else if ("/sensitive".equals(request.getUrl())) {
                String sessionId = request.getHeader("SESSION");
                String userInfo = SESSION.get(sessionId);
                System.out.println("====================获取到的用户信息" + userInfo);

            } else {//以上所有路径都找不到，说明我们服务器不提供该URL的服务，返回404
                response.build404();
                response.println("找不到资源");
            }
            //返回数据给客户端
        } catch (Exception e) {
            e.printStackTrace();
            response.build500();
            response.println("服务器出错");
        } finally {//始终需要刷新响应数据
            response.flush();
        }
    }
}
