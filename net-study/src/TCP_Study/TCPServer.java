package TCP_Study;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TCPServer {

    private static final int PORT = 9999;

    private static final ExecutorService EXE = Executors.newCachedThreadPool();

    public static void main(String[] args) throws IOException {
        //启动TCP服务器
        ServerSocket serverSocket = new ServerSocket(PORT);

        //循环获取新的客户端连接
        while (true) {

            Socket socket = serverSocket.accept();

            EXE.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        //阻塞，等待新的客户端连接

                        //处理客户端连接的业务，这个业务可能会发生阻塞
                        //先不考虑阻塞

                        //获取二进制输入流
                        InputStream is = socket.getInputStream();
                        //将二进制输入流转化为字符缓冲流
                        BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));

                        //获取二进制输出流
                        OutputStream os = socket.getOutputStream();
                        //将二进制输出流转化为字符缓冲流
                        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));

                        //1.先接受客户端传过来的数据，并打印
                        //2.响应给客户端一个数据
                        String line;

                        while ((line = br.readLine()) != null) {
                            System.out.println("服务端接收到数据:" + line);
                            bw.write("我已经接收到了" + line + "消息\n");
                            //需要刷新一下缓冲区,这时才会将数据发送给对端
                            bw.flush();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }
}
