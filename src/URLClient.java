import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Calendar;
import java.util.Random;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import net.sf.json.JSONObject;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.time.StopWatch;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class URLClient {
    StringBuilder sb = new StringBuilder();

    private static byte[] encrypt(byte[] keyBytes, byte[] srcBytes) throws Exception {
        if (keyBytes == null || srcBytes == null) {
            return null;
        }
        SecretKeySpec skeySpec = new SecretKeySpec(keyBytes, "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
        byte[] encrypted = cipher.doFinal(srcBytes);
        return encrypted;
    }

    public static String securityDoCipher(String rawJson) throws Exception {
        int keylength = 16;
        byte[] key = new byte[keylength];
        Random r = new Random();
        r.setSeed(Calendar.getInstance().getTimeInMillis());

        for (int i = 0; i < keylength; i++) {
            if (r.nextInt(2) == 0) {
                key[i] = (byte) ((r.nextInt(26) & 0xff) + 'A');
            } else {
                key[i] = (byte) ((r.nextInt(10) & 0xff) + '0');
            }
        }
        byte[] encrypted = encrypt(key, rawJson.getBytes("utf-8"));
        String cipherHex = new String(Hex.encodeHex(encrypted, false));
        StringBuffer sb = new StringBuffer();
        int i = 0;
        sb.append(cipherHex.charAt(i++));
        sb.append(cipherHex.charAt(i++));
        JSONObject jo = JSONObject.fromObject(rawJson);
        String transactionid = jo.getString("transactionid");
        String timestamp = jo.getString("timestamp");
        keylength = keylength + transactionid.length() + timestamp.length();
        sb.append((char) ((keylength & 0x3fc0) >> 6));
        sb.append((char) ((keylength & 0x30) >> 4));
        sb.append((char) ((keylength & 0xc) >> 2));
        sb.append((char) ((keylength & 0x3) >> 0));

        sb.append(transactionid);
        sb.append(timestamp);
        for (byte c : key) {
            sb.append((char) c);
        }
        sb.append(cipherHex.substring(2));
        return sb.toString();
    }

    public static void main(String[] args) {
        /*
         * { 　　"msgname": "qryrecognizersp", 　　"transactionid": "123456", 　　"msgsender":"usrclient", "timestamp":"20130125111700", "cont":{ 　　　　
         * "buildingid":2, 　　　　　　"img":"JHU&%RFHHVCGHJHJHBCD$%^G" }
         * 
         * }
         */

        // Thread[] ts1 = new Reg[1];
        //
        // for (int i = 0; i < ts1.length; i++) {
        // ts1[i] = new URLClient.Reg();
        // ts1[i].start();
        // }

        {
            Thread[] ts3 = new Qry[100];

            for (int i = 0; i < ts3.length; i++) {
                ts3[i] = new URLClient.Qry();
                ts3[i].start();
            }

        }

        // {
        // Thread[] ts3 = new QQ[1000];
        //
        // for (int i = 0; i < ts3.length; i++) {
        // ts3[i] = new URLClient.QQ();
        // ts3[i].start();
        // }
        //
        // }

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
                    url = new URL("http://10.123.77.91/baiyun/requestHandler");
                    // url = new URL("http://10.123.124.147/baiyun/requestHandler");
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
                    // jo.put("msgname", "qryfltlistreq");
                    jo.put("msgname", "concentrationreq");
                    jo.put("transactionid", "123456");
                    jo.put("msgsender", "usrclient");
                    jo.put("timestamp", "20130125111700");

                    JSONObject cont = new JSONObject();
                    cont.put("pushtoken", "OUJHGFKYYYYYYYSDRSWAERGDXHJ");
                    cont.put("flightdate", "2013-09-12 05:05:05");
                    cont.put("flightnumber", "");
                    cont.put("dstid", "CZ1234");
                    cont.put("ostype", "1");
                    cont.put("contype", "0");
                    cont.put("systemversion", "5.1");
                    cont.put("carriername", "中国移动");
                    cont.put("airlinecode", "CZ");
                    cont.put("fromcitycode", "PEK");
                    cont.put("tocitycode", "CAN");
                    // cont.put("whichday", 0);
                    // cont.put("fromcity", "CAN");
                    // cont.put("tocity", "PEK");
                    jo.put("cont", cont);

                    URL url = null;
                    HttpURLConnection conn = null;
                    // url = new URL("http://10.124.147.150/BaiYunAirport/requestHandler");
                    url = new URL("http://10.123.76.169/BaiYunAirport/requestHandler");
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
                    os.write(securityDoCipher(jo.toString()).getBytes("utf-8"));
                    os.close();

                    InputStream is = conn.getInputStream();
                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    IOUtils.copy(is, baos);
                    sw.split();

                    String jsonResult = baos.toString("utf-8");
                    System.out.printf("Qry=>tid : %d =>time: %d ms=>rslt:%s\n", this.getId(),
                            sw.getSplitTime() - p, jsonResult);
                    p = sw.getSplitTime();
                    // Thread.sleep(500);
                }
            } catch (Throwable t) {
                t.printStackTrace();
            }

        }
    }

    public static class QQ extends Thread {

        @Override
        public void run() {
            try {
                long p = 0L;
                StopWatch sw = new StopWatch();
                sw.start();
                while (true) {

                    try {
                        URL url = null;
                        HttpURLConnection conn = null;
                        // url = new URL("http://10.124.147.150/BaiYunAirport/requestHandler");
                        url = new URL(
                                "http://localhost/baiyun/crisisPoint/crisisPoint!hello.action");
                        // url = new URL("http://10.123.76.169/baiyun/requestHandler");
                        conn = (HttpURLConnection) url.openConnection();

                        conn.setDoInput(true);
                        conn.setDoOutput(true);
                        conn.setUseCaches(false);
                        conn.setConnectTimeout(30000);
                        conn.setRequestMethod("POST");
                        conn.setRequestProperty("Charset", "UTF-8");
                        conn.setRequestProperty("Content-Type", "text/xml");

                        InputStream is = conn.getInputStream();
                        ByteArrayOutputStream baos = new ByteArrayOutputStream();
                        IOUtils.copy(is, baos);
                        sw.split();

                        String jsonResult = baos.toString("utf-8");
                        System.out.printf("QQQ=>tid : %d =>time: %d ms=>rslt:%s\n", this.getId(),
                                sw.getSplitTime() - p, jsonResult);
                        p = sw.getSplitTime();
                        Thread.sleep(50);
                    } catch (Exception e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
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
