import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;

import org.apache.commons.io.IOUtils;

public class test4_UrlProxy {
    public static void main(String[] args) {
        try {
            URL url = new URL("http://www.baidu.com");
            InetSocketAddress addr = new InetSocketAddress("10.123.74.137", 808);
            Proxy proxy = new Proxy(Proxy.Type.HTTP, addr);
            URLConnection conn = url.openConnection(proxy);

            InputStream in = conn.getInputStream();
            String s = IOUtils.toString(in);
            System.out.println(s);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
