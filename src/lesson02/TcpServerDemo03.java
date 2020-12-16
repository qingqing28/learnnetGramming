package lesson02;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServerDemo03 {
    public static void main(String[] args) throws Exception{
        //1.创建服务
        ServerSocket serverSocket = new ServerSocket(9000);
        //2.监听客户端的连接
        Socket socket = serverSocket.accept();
        //建立输入流
        InputStream is = socket.getInputStream();
        FileOutputStream fos = new FileOutputStream(new File("new.jpg"));
        byte[] buffer = new byte[1024];
        int len ;
        while((len = is.read(buffer) ) != -1){
            fos.write(buffer , 0 , len);
        }

        //4.告诉服务器，已经接收完毕
        OutputStream os = socket.getOutputStream();
        os.write("我已经接受完毕".getBytes());

        os.close();
        fos.close();
        is.close();
        socket.close();
    }
}
