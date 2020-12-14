package lesson02;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class TcpClientDemo02 {
    public static void main(String[] args) {
        Socket socket = null;
        OutputStream os = null;
        try {
            //1.要知道服务器的地址
            InetAddress serverIp = InetAddress.getByName("127.0.0.1");
            //2.要知道服务器的端口
            int port = 9999;
            //3.和服务器建立连接
            socket = new Socket(serverIp , port);
            //4.发送消息
            os = socket.getOutputStream();
            os.write("你好，欢迎进行测试".getBytes());


        }catch(Exception e){
            e.printStackTrace();
        }finally {
            if(os != null){
                try{
                    os.close();
                }catch(IOException e){
                    e.printStackTrace();
                }
            }

            if(socket != null){
                try {
                    socket.close();
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
        }

    }
}
