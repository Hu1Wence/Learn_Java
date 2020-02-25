package TCP_Study;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class TCPClient {

    private static final String HOST = "localhost";
    //本机默认域名是localhost, 默认IP是127.0.0.1
    //private static final String HOST = "127.0.0.1";
    private static final int PORT = 9999;

    public static void main(String[] args) throws IOException {
        //建立了客户端的tcp连接
        Socket socket = new Socket(HOST, PORT);

        //获取二进制输入流
        InputStream is = socket.getInputStream();
        //将二进制输入流转化为字符缓冲流
        BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));

        //获取二进制输出流
        OutputStream os = socket.getOutputStream();
        //将二进制输出流转化为字符缓冲流
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
        PrintWriter pw = new PrintWriter(os, true);
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            pw.println(line);

            String response = br.readLine();
            System.out.println("接收到服务端响应："+ response);
        }

    }

}
