package lesson02;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class TcpClientDemo03 {
    public static void main(String[] args) throws Exception{
        //1.建立一个socket连接
        Socket socket = new Socket(InetAddress.getByName("127.0.0.1"),9000);
        //2.创建一个输出流
        OutputStream os = socket.getOutputStream();

        //3.读取文件
        FileInputStream fis = new FileInputStream(new File("iphone.jpg"));
         byte[] buffer = new byte[1024];
         int len;
         while((len = fis.read(buffer)) != -1){
             os.write(buffer , 0 , len);
         }

         //4.通知服务器，我已经结束
        socket.shutdownOutput();

         //5.确定服务器接受完毕
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        InputStream is = socket.getInputStream();
        //byte[] buffer2 = new byte[1024];
        while((len = is.read(buffer)) != -1){
            baos.write(buffer , 0 , len);
        }
        System.out.println(baos.toString());

        is.close();
        baos.close();
        fis.close();os.close();
        socket.close();
    }
}
