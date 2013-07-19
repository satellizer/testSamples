import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import net.sf.json.JSONObject;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.time.StopWatch;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class URLClient {
    StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        /*
         * { 　　"msgname": "qryrecognizersp", 　　"transactionid": "123456", 　　"msgsender":"usrclient", "timestamp":"20130125111700", "cont":{ 　　　　
         * "buildingid":2, 　　　　　　"img":"JHU&%RFHHVCGHJHJHBCD$%^G" }
         * 
         * }
         */
        // Thread[] ts1 = new Reg[5];
        //
        // for (int i = 0; i < ts1.length; i++) {
        // ts1[i] = new URLClient.Reg();
        // ts1[i].start();
        // }

        {
            Thread[] ts3 = new Qry[5];

            for (int i = 0; i < ts3.length; i++) {
                ts3[i] = new URLClient.Qry();
                ts3[i].start();
            }
        }

        // Thread[] ts4 = new Shops[5];
        //
        // for (int i = 0; i < ts4.length; i++) {
        // ts4[i] = new URLClient.Shops();
        // ts4[i].start();
        // }

        // {
        // Thread[] ts2 = new FileThread[1];
        //
        // for (int i = 0; i < ts2.length; i++) {
        // ts2[i] = new URLClient.FileThread();
        // ts2[i].start();
        // }
        // }

    }

    public static class Reg extends Thread {

        @Override
        public void run() {
            try {
                long p = 0L;
                StopWatch sw = new StopWatch();
                sw.start();
                while (true) {
                    JSONObject jo = new JSONObject();
                    jo.put("msgname", "qryrecognizereq");
                    jo.put("transactionid", "123456");
                    jo.put("msgsender", "usrclient");
                    jo.put("timestamp", "20130125111700");

                    JSONObject cont = new JSONObject();
                    cont.put("buildingid", 1);
                    BASE64Decoder dec = new BASE64Decoder();
                    BASE64Encoder enc = new BASE64Encoder();

                    InputStream iiiiis = new FileInputStream(new File(
                            "E:\\Files\\CellPhone\\BaiYun\\image\\ALL-2013-5-20\\10800810 (5).JPG"));
                    ByteArrayOutputStream bbbbbaos = new ByteArrayOutputStream();
                    IOUtils.copy(iiiiis, bbbbbaos);
                    String base64img = enc.encode(bbbbbaos.toByteArray());

                    cont.put("img", base64img);
                    jo.put("cont", cont);

                    URL url = null;
                    HttpURLConnection conn = null;
                    url = new URL("http://10.124.147.150/baiyun/requestHandler");
                    conn = (HttpURLConnection) url.openConnection();

                    conn.setDoInput(true);
                    conn.setDoOutput(true);
                    conn.setUseCaches(false);
                    conn.setConnectTimeout(30000);
                    conn.setRequestMethod("POST");
                    conn.setRequestProperty("Charset", "UTF-8");
                    conn.setRequestProperty("Content-Type", "text/xml");

                    OutputStream os = conn.getOutputStream();
                    os.write(jo.toString().getBytes("utf-8"));
                    os.close();

                    InputStream is = conn.getInputStream();
                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    IOUtils.copy(is, baos);
                    sw.split();

                    String jsonResult = baos.toString("utf-8");
                    System.out.printf("Reg=>tid : %d =>time: %d ms=>rslt:%s\n", this.getId(),
                            sw.getSplitTime() - p, jsonResult);
                    p = sw.getSplitTime();
                }
            } catch (Throwable t) {
                t.printStackTrace();
            }

        }
    }

    public static class Qry extends Thread {

        @Override
        public void run() {
            try {
                long p = 0L;
                StopWatch sw = new StopWatch();
                sw.start();
                while (true) {
                    // {
                    // "msgname": "qryfltlistreq",
                    // "transactionid": "123456",
                    // "msgsender":"usrclient",
                    // "timestamp":"20130125111700",
                    // "cont": {
                    // "whichday":0,
                    // "flightnumber":"CZ1234",
                    // "fromcity":"CAN",
                    // "tocity":"PEK"
                    // }
                    // }
                    JSONObject jo = new JSONObject();
                    jo.put("msgname", "qryroutingreq");
                    jo.put("transactionid", "123456");
                    jo.put("msgsender", "usrclient");
                    jo.put("timestamp", "20130125111700");

                    JSONObject cont = new JSONObject();
                    cont.put("srcid", 128301);
                    cont.put("dstid", 500003);
                    // cont.put("whichday", 0);
                    // cont.put("fromcity", "CAN");
                    // cont.put("tocity", "PEK");
                    jo.put("cont", cont);

                    URL url = null;
                    HttpURLConnection conn = null;
                    // url = new URL("http://10.124.147.150/BaiYunAirport/requestHandler");
                    url = new URL("http://10.123.77.91/baiyun/requestHandler");
                    // url = new URL("http://10.123.76.169/baiyun/requestHandler");
                    conn = (HttpURLConnection) url.openConnection();

                    conn.setDoInput(true);
                    conn.setDoOutput(true);
                    conn.setUseCaches(false);
                    conn.setConnectTimeout(30000);
                    conn.setRequestMethod("POST");
                    conn.setRequestProperty("Charset", "UTF-8");
                    conn.setRequestProperty("Content-Type", "text/xml");

                    OutputStream os = conn.getOutputStream();
                    os.write(jo.toString().getBytes("utf-8"));
                    os.close();

                    InputStream is = conn.getInputStream();
                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    IOUtils.copy(is, baos);
                    sw.split();

                    String jsonResult = baos.toString("utf-8");
                    System.out.printf("Qry=>tid : %d =>time: %d ms=>rslt:%s\n", this.getId(),
                            sw.getSplitTime() - p, jsonResult);
                    p = sw.getSplitTime();
                    Thread.sleep(500);
                }
            } catch (Throwable t) {
                t.printStackTrace();
            }

        }
    }

    public static class Shops extends Thread {

        @Override
        public void run() {
            try {
                long p = 0L;
                StopWatch sw = new StopWatch();
                sw.start();
                while (true) {
                    // {
                    // "msgname": "qryshopsreq",
                    // "transactionid": "123456",
                    // "msgsender":"usrclient",
                    // "timestamp":"20130125111700",
                    // "cont":{
                    // "buildingid":2,
                    // "pagesize":10,
                    // "currpage":1,
                    // "content":"ochirly"
                    // }
                    // }
                    JSONObject jo = new JSONObject();
                    jo.put("msgname", "qryshopsreq");
                    jo.put("transactionid", "123456");
                    jo.put("msgsender", "usrclient");
                    jo.put("timestamp", "20130125111700");

                    JSONObject cont = new JSONObject();
                    cont.put("buildingid", 1);
                    cont.put("content", "sal");
                    jo.put("cont", cont);

                    URL url = null;
                    HttpURLConnection conn = null;
                    url = new URL("http://10.124.147.150/baiyun/requestHandler");
                    conn = (HttpURLConnection) url.openConnection();

                    conn.setDoInput(true);
                    conn.setDoOutput(true);
                    conn.setUseCaches(false);
                    conn.setConnectTimeout(30000);
                    conn.setRequestMethod("POST");
                    conn.setRequestProperty("Charset", "UTF-8");
                    conn.setRequestProperty("Content-Type", "text/xml");

                    OutputStream os = conn.getOutputStream();
                    os.write(jo.toString().getBytes("utf-8"));
                    os.close();

                    InputStream is = conn.getInputStream();
                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    IOUtils.copy(is, baos);
                    sw.split();

                    String jsonResult = baos.toString("utf-8");
                    System.out.printf("Shops=>tid : %d =>time: %d ms=>rslt:%s\n", this.getId(),
                            sw.getSplitTime() - p, jsonResult);
                    p = sw.getSplitTime();
                }
            } catch (Throwable t) {
                t.printStackTrace();
            }

        }
    }

    public static class FileThread extends Thread {

        @Override
        public void run() {
            try {
                while (true) {

                    File file = new File("C:\\Users\\Administrator\\Desktop\\20130527174127.txt.gz");

                    InputStream iiiiis = new FileInputStream(file);
                    ByteArrayOutputStream bbbbbaos = new ByteArrayOutputStream();
                    IOUtils.copy(iiiiis, bbbbbaos);

                    URL url = null;
                    HttpURLConnection conn = null;
                    url = new URL(
                            "http://10.124.147.150/BaiYunAirport/pushData/pushData!push.action");
                    // url = new URL("http://10.123.76.169/BaiYunAirport/pushData/pushData!push.action");
                    conn = (HttpURLConnection) url.openConnection();

                    conn.setDoInput(true);
                    conn.setDoOutput(true);
                    conn.setUseCaches(false);
                    conn.setConnectTimeout(30000);
                    conn.setRequestMethod("POST");
                    conn.setRequestProperty("Charset", "UTF-8");
                    String BOUNDARY = "---------------------------7dd03a2803f8";
                    conn.setRequestProperty("Content-Type", "multipart/form-data;boundary="
                            + BOUNDARY);

                    OutputStream os = conn.getOutputStream();

                    byte[] content = bbbbbaos.toByteArray();

                    StringBuilder split = new StringBuilder();
                    split.append("--");
                    split.append(BOUNDARY);
                    split.append("\r\n");
                    split.append("Content-Disposition: form-data;name=\"data\";filename=\""
                            + file.getAbsolutePath() + "\"\r\n");
                    split.append("Content-Type: text/xml\r\n\r\n");

                    os.write(split.toString().getBytes());
                    // System.out.print(split.toString());

                    os.write(content, 0, content.length);
                    // System.out.print(new String(content));

                    os.write("\r\n".getBytes());
                    // System.out.print("\r\n");

                    byte[] end_data = ("--" + BOUNDARY + "--\r\n").getBytes();// 数据结束标志
                    os.write(end_data);
                    // System.out.print(new String(end_data));
                    os.flush();
                    os.close();

                    System.out.printf("code : %d\n", conn.getResponseCode());
                    InputStream is = conn.getInputStream();
                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    IOUtils.copy(is, baos);
                    is.close();
                    String jsonResult = baos.toString("utf-8");
                    baos.close();
                    System.out.printf("thread id : %d =>result:%s\n", this.getId(), jsonResult);

                    Thread.sleep(6000L);
                }
            } catch (Throwable t) {
                t.printStackTrace();
            }

        }
    }
}
