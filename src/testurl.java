import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Random;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/*
 * @(#) testurl.java
 * @Author:windheaven(mail) 2013-8-7
 * @Copyright (c) 2002-2013 Travelsky Limited. All rights reserved.
 */

/**
  * @author windheaven(mail) 2013-8-7
  * @version 1.0
  * @modifyed by windheaven(mail) description
  * @Function 类功能说明
  */
public class testurl {

    /**
      * 创建一个新的实例 
      */
    public testurl() {
        // TODO Auto-generated constructor stub
    }

    /**
      * main(这里用一句话描述这个方法的作用)
      * @param args
     * @throws Exception 
      */
    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub

        try {
            URL url = null;
            HttpURLConnection conn = null;
            url = new URL("http://10.123.124.144:8080/mobile_interface/manager");
            conn = (HttpURLConnection) url.openConnection();

            conn.setDoInput(true);
            conn.setDoOutput(true);
            conn.setUseCaches(false);
            conn.setConnectTimeout(30000);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Charset", "UTF-8");
            conn.setRequestProperty("Content-Type", "text/xml");

            OutputStream os = conn.getOutputStream();
            os.write(getuser().getBytes("utf-8"));
            // os.write(updname().getBytes("utf-8"));
            os.close();

            InputStream is = conn.getInputStream();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();

            int length = 0;
            byte[] buff = new byte[4096];
            while ((length = is.read(buff)) != -1) {
                baos.write(buff, 0, length);
            }

            String jsonResult = baos.toString("utf-8");
            StringReader sr = new StringReader(jsonResult);
            SAXReader sa = new SAXReader();
            Document doc = sa.read(sr);
            System.out.println(jsonResult);
            Element root = doc.getRootElement();
            System.out.println(doc.getRootElement().element("cont").element("userinfo")
                    .elementText("firstname"));
            System.out.println(doc.getRootElement().element("cont").element("userinfo")
                    .elementText("lastname"));

        } catch (MalformedURLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        } catch (ProtocolException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        } catch (UnsupportedEncodingException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

    }

    /**
      * getuser(这里用一句话描述这个方法的作用)
      * @return
      */
    private static String getuser() {
        return "<?xml version=\"1.0\" encoding=\"UTF-8\"?><travelsky>  <msgname>getusrinforeq</msgname><transactionid>1358757647719</transactionid><timestamp>20130114120301</timestamp><msgsender>usrclient</msgsender><cont>  <userid>1244775</userid>  <pushtoken>pc</pushtoken></cont></travelsky>";
    }

    private static String updname() {
        Random r = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 10; i++) {
            sb.append(r.nextInt());
        }
        return "<?xml version\"1.0\" encoding\"UTF-8\"?><travelsky><msgname>updusrnamereq</msgname><transactionid>1358757647719</transactionid><timestamp>20130114120401</timestamp><msgsender>portal</msgsender><cont><userid>1244775</userid><lastname>"
                + sb.toString()
                + "</lastname><firstname>"
                + sb.toString()
                + "</firstname><pushtoken>pc</pushtoken></cont></travelsky>";
    }
}
