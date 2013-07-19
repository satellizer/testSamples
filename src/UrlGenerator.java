import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.zip.CRC32;
import java.util.zip.CheckedInputStream;

import org.iq80.leveldb.util.PureJavaCrc32C;
import org.springframework.util.StringUtils;

public class UrlGenerator {

    public static void main(String[] args) {
        // String result = decodeString(args[0], "GBK");
        // String result = decodeString("6162B4F36364BCD2657CBAC366", "GBK");
        // String result = decodeString("E8B0A2E99C86E9948B", "utf-8");

        String result = string2bytes("8月 去上海", "utf-8");
        System.out.println(StringUtils.replace(result, "%", "%25"));

        String tse = string2bytes("谢霆锋", "utf-8");
        System.out.println(StringUtils.replace(tse, "%", "%25"));

        result = generatorUrl(new String[] { "8月", "去上海" }, "s.weibo.com/weibo/", "utf-8");
        System.out.println(result);
        CheckedInputStream cis;
        try {
            // 59 37 00 00
            cis = new CheckedInputStream(new FileInputStream("original"), new PureJavaCrc32C());
            cis.read(new byte[cis.available()]);
            String cs = Integer.toBinaryString((int) (cis.getChecksum().getValue() & 0xffffffff));
            for (int i = 0; i < 32 - cs.length(); i++) {
                cs = "0" + cs;
            }
            System.out.println(String.format("%x", cis.getChecksum().getValue()));
            System.out.println(cs.substring(0, 16));
            System.out.println(cs.substring(16));
            String cs2 = Integer.toBinaryString((int) (Long.decode("#b32a0000") & 0xffffffff));
            for (int i = 0; i < 32 - cs2.length(); i++) {
                cs2 = "0" + cs2;
            }
            System.out.println();
            System.out.println(cs2.substring(0, 16));
            System.out.println(cs2.substring(16));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String generatorUrl(String[] keywords, String site, String encoding) {
        StringBuffer strBuff = new StringBuffer();
        for (String s : keywords) {
            strBuff.append(s);
            strBuff.append(" ");
        }
        if (keywords.length > 1) {
            strBuff.deleteCharAt(strBuff.length() - 1);
        }
        String tmp = strBuff.toString();
        String bytestr = string2bytes(tmp, encoding);
        strBuff.delete(0, tmp.length());
        strBuff.append(site.endsWith("/") ? site : site + "/");
        strBuff.append(StringUtils.replace(bytestr, "%", "%25"));
        return strBuff.toString();

    }

    private static String decodeString(String string, String encoding) {
        try {
            byte[] data = string2Bytes(string);
            return new String(data, encoding);
        } catch (UnsupportedEncodingException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    /**
      * string2Bytes(这里用一句话描述这个方法的作用)
      * @param string radix 16 string
      * @return
      */
    private static byte[] string2Bytes(String string) {
        int blen = string.length() / 2;
        byte[] data = new byte[blen];
        for (int i = 0; i < blen; i++) {
            String bStr = string.substring(2 * i, 2 * (i + 1));
            data[i] = (byte) Integer.parseInt(bStr, 16);
        }
        return data;
    }

    /**
      * string2bytes(这里用一句话描述这个方法的作用)
      * @param string source string to be parsed to radix 16
      * @param encoding character set
      * @return
      */
    private static String string2bytes(String string, String encoding) {
        try {
            StringBuilder sb = new StringBuilder();
            for (char c : string.toCharArray()) {

                for (byte b : Character.toString(c).getBytes(encoding)) {
                    String t = null;
                    if ((t = isUrlEncoding(c, encoding)) != null) {
                        sb.append(t);
                        continue;
                    }
                    t = Integer.toHexString((b & 0xff)).toUpperCase();
                    sb.append('%');
                    sb.append(t);
                }
            }
            return sb.toString();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
      * isUrlEncoding(这里用一句话描述这个方法的作用)
      * @param c
      * @return
      */
    private static String isUrlEncoding(char c, String encoding) {
        try {
            String t = Character.toString(c);
            if (t.getBytes(encoding).length > 1) {
                return null;
            } else {
                switch (c) {
                case ' ':
                    return "%20";
                default:
                    return t;
                }
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }
}
