import java.io.Closeable;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.Socket;
import java.net.URL;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;

import org.springframework.orm.ObjectRetrievalFailureException;
import org.springframework.util.StringUtils;

public class test12 {

    public static void close(Closeable... cs) {
        if (null != cs) {
            for (Closeable c : cs) {
                if (null != c) {
                    try {
                        c.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    /**
      * main(这里用一句话描述这个方法的作用)
      * @param args
      */
    public static void main(String[] args) {
        // {
        // Calendar c = Calendar.getInstance();
        // c.set(Calendar.HOUR_OF_DAY, 0);
        // c.set(Calendar.MINUTE, 0);
        // c.set(Calendar.SECOND, 0);
        // c.set(Calendar.MILLISECOND, 0);
        // Date today = c.getTime();
        // c.set(Calendar.DAY_OF_MONTH, c.get(Calendar.DAY_OF_MONTH) + 2);
        // Date tomorrow = c.getTime();
        //
        // System.out.println(today.toString());
        // System.out.println(tomorrow.toString());
        // }
        try {
            Socket s = new Socket(new Proxy(Type.HTTP, new InetSocketAddress("10.123.74.137", 808)));
            s.connect(new InetSocketAddress("http://www.baidu.com", 80));
            close(s.getInputStream(), s.getOutputStream(), s);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
