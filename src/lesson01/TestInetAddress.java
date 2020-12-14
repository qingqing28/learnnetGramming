package lesson01;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class TestInetAddress {
    public static void main(String[] args) {
        try {
            //查询本机地址
            InetAddress inetAddress1 = InetAddress.getByName("127.0.0.1");
            System.out.println(inetAddress1);
            InetAddress inetAddress2 = InetAddress.getByName("localhost");
            System.out.println(inetAddress2);
            InetAddress inetAddress3 = InetAddress.getLocalHost();
            System.out.println(inetAddress3);
            
            //查询网站地址
            InetAddress inetAddress4 = InetAddress.getByName("www.baidu.com");
            System.out.println(inetAddress4);
            System.out.println();
            System.out.println(inetAddress2.getAddress());
            System.out.println(inetAddress2.getCanonicalHostName());
            System.out.println(inetAddress2.getHostName());
            System.out.println(inetAddress2.getHostAddress());

            System.out.println(inetAddress4.getAddress());
            System.out.println(inetAddress4.getCanonicalHostName());
            System.out.println(inetAddress4.getHostName());
            System.out.println(inetAddress4.getHostAddress());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }


    }
}
