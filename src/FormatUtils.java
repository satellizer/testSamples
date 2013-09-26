/*
 * @(#) N.java
 * @Author:windheaven(mail) 2013-4-27
 * @Copyright (c) 2002-2013 Travelsky Limited. All rights reserved.
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import net.sf.json.JSON;
import net.sf.json.JSONObject;
import net.sf.json.xml.XMLSerializer;

import org.apache.log4j.Logger;

/**
  * @author windheaven(mail) 2013-5-2
  * @version 1.0
  * @modifyed by windheaven(mail) description
  * @Function 类功能说明
  */
public class FormatUtils {

    private static Logger logger = Logger.getLogger(FormatUtils.class);

    private static SimpleDateFormat yyyyMMddxhhmmss = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss",
            Locale.ENGLISH);
    private static SimpleDateFormat yyyyMMddxhhmm = new SimpleDateFormat("yyyy-MM-dd HHmm",
            Locale.ENGLISH);
    private static SimpleDateFormat yyyyMMddHHmmss = new SimpleDateFormat("yyyyMMddHHmmss",
            Locale.ENGLISH);
    private static SimpleDateFormat yyyyMMddHHmmssSSS = new SimpleDateFormat("yyyyMMddHHmmssSSS",
            Locale.ENGLISH);
    private static SimpleDateFormat yyyyMMdd = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
    private static SimpleDateFormat hhmm = new SimpleDateFormat("HH:mm", Locale.ENGLISH);
    private static SimpleDateFormat mmddHHmm = new SimpleDateFormat("MM月dd日HH:mm", Locale.ENGLISH);
    private static SimpleDateFormat md = new SimpleDateFormat("M月d日", Locale.ENGLISH);
    private static SimpleDateFormat mde = new SimpleDateFormat("M月d日 周E", Locale.ENGLISH);

    /**
      * Date2yyyyMMdd_hhmmss(yyyy-MM-dd HH:mm:ss)
      * @param date
      * @return
      */

    public static String date2yyyyMMddxhhmmss(Date date) {
        if (null == date) {
            return "";
        }

        String updateDateTimeStamp = yyyyMMddxhhmmss.format(date);

        return updateDateTimeStamp;

    }

    /**
     * Date2yyyyMMddHHmmss(yyyyMMddHHmmss)
     * @param date
     * @return
     */
    public static String date2yyyyMMddHHmmss(Date date) {
        // TODO Auto-generated method stub
        if (null == date) {
            return "";
        }

        String updateDateTimeStamp = yyyyMMddHHmmss.format(date);

        return updateDateTimeStamp;

    }

    /**
     * Date2yyyyMMddHHmmssSSS(yyyyMMddHHmmssSSS)
     * @param date
     * @return
     */
    public static String date2yyyyMMddHHmmssSSS(Date date) {
        // TODO Auto-generated method stub
        if (null == date) {
            return "";
        }

        String updateDateTimeStamp = yyyyMMddHHmmssSSS.format(date);

        return updateDateTimeStamp;

    }

    /**
      * Date2yyyyMMdd(yyyy-MM-dd)
      * @param date
      * @return
      */
    public static String date2yyyyMMdd(Date date) {
        if (null == date) {
            return "";
        }

        String updateDateTimeStamp = yyyyMMdd.format(date);

        return updateDateTimeStamp;
    }

    /**
     * Date2HH_mm(hh:mm)
     * @param date
     * @return
     */
    public static String date2HHxmm(Date date) {
        if (null == date) {
            return "";
        }

        String updateDateTimeStamp = hhmm.format(date);

        return updateDateTimeStamp;
    }

    /**
     * Date2MMdd_hhmm(MM月dd日hh:mm)
     * @param date
     * @return
     */
    public static String date2MMddxhhmm(Date date) {
        if (null == date) {
            return "";
        }

        String updateDateTimeStamp = mmddHHmm.format(date);

        return updateDateTimeStamp;
    }

    /**
      * Date2MMdd(M月d日)
      * @param date
      * @return
      */
    public static String date2MMdd(Date date) {
        if (null == date) {
            return "";
        }

        String updateDateTimeStamp = md.format(date);

        return updateDateTimeStamp;
    }

    /**
      * Date2MMdd_ww(MM月dd日 周ww)
      * @param date
      * @return
      */
    public static String date2MMddxww(Date date) {
        if (null == date) {
            return "";
        }

        String updateDateTimeStamp = mde.format(date);
        updateDateTimeStamp = updateDateTimeStamp.replace("Sun", "日");
        updateDateTimeStamp = updateDateTimeStamp.replace("Mon", "一");
        updateDateTimeStamp = updateDateTimeStamp.replace("Tue", "二");
        updateDateTimeStamp = updateDateTimeStamp.replace("Wed", "三");
        updateDateTimeStamp = updateDateTimeStamp.replace("Thu", "四");
        updateDateTimeStamp = updateDateTimeStamp.replace("Fri", "五");
        updateDateTimeStamp = updateDateTimeStamp.replace("Sat", "六");
        // Calendar c = Calendar.getInstance();
        // c.setTime(date);
        // switch (c.get(Calendar.DAY_OF_WEEK)) {
        // case 1:
        // return updateDateTimeStamp + '日';
        // // break;
        // case 2:
        // return updateDateTimeStamp + '一';
        // // break;
        // case 3:
        // return updateDateTimeStamp + '二';
        // // break;
        // case 4:
        // return updateDateTimeStamp + '三';
        // // break;
        // case 5:
        // return updateDateTimeStamp + '四';
        // // break;
        // case 6:
        // return updateDateTimeStamp + '五';
        // // break;
        // case 7:
        // return updateDateTimeStamp + '六';
        // // break;
        // default:
        // break;
        // }
        return updateDateTimeStamp;
    }

    /**
      * yyyyMMdd_hhmmss2Date(yyyy-MM-dd HH:mm:ss)
      * @param date
      * @return
      */
    public static Date yyyyMMddxhhmmss2Date(String date) {
        if (null == date) {
            return null;
        }

        Date updateDateTimeStamp = null;
        try {
            updateDateTimeStamp = yyyyMMddxhhmmss.parse(date);
        } catch (ParseException e) {
            logger.error(e.getMessage(), e);
        }

        return updateDateTimeStamp;

    }

    /**
     * yyyyMMddxhhmm2Date(yyyy-MM-dd HHmm)
     * @param date
     * @return
     */
    public static Date yyyyMMddxhhmm2Date(String date) {
        if (null == date) {
            return null;
        }

        Date updateDateTimeStamp = null;
        try {
            updateDateTimeStamp = yyyyMMddxhhmm.parse(date);
        } catch (ParseException e) {
            logger.error(e.getMessage(), e);
        }

        return updateDateTimeStamp;

    }

    /**
     * Date2yyyyMMddHHmmss(yyyyMMddHHmmss2Date,no notation)
     * @param date
     * @return
     */
    public static Date yyyyMMddHHmmss2Date(String date) {
        // TODO Auto-generated method stub
        if (null == date) {
            return null;
        }

        Date updateDateTimeStamp = null;
        try {
            updateDateTimeStamp = yyyyMMddHHmmss.parse(date);
        } catch (ParseException e) {
            logger.error(e.getMessage(), e);
        }

        return updateDateTimeStamp;

    }

    /**
      * yyyyMMdd2Date(yyyy-MM-dd)
      * @param date
      * @return
      */
    public static Date yyyyMMdd2Date(String date) {
        if (null == date) {
            return null;
        }

        Date updateDateTimeStamp = null;
        try {
            updateDateTimeStamp = yyyyMMdd.parse(date);
        } catch (ParseException e) {
            logger.error(e.getMessage(), e);
        }

        return updateDateTimeStamp;
    }

    /**
     * Json2Xml(translate json into xml,automatically insert into the\<traveksky\>)
     * @param xml
     * @return
     */

    public static String json2Xml(String json) {
        JSONObject jo = JSONObject.fromObject(json);

        XMLSerializer xs = new XMLSerializer();
        xs.setRootName("travelsky");
        xs.setTypeHintsEnabled(false);
        String xml = xs.write(jo);

        return xml;
    }

    /**
     * Xml2Json(translate xml into json)
     * @param xml
     * @return
     */
    public static String xml2Json(String xml) {
        /* suppose translation has been done */
        XMLSerializer xs = new XMLSerializer();
        JSON jo = xs.read(xml);
        String json = jo.toString();
        return json;
    }

    /**
      * main(这里用一句话描述这个方法的作用)
      * @param args
      */
    public static void main(String[] args) {

        // {JSONObject jjo = new JSONObject();
        // jjo.put("airlines", "one");
        // jjo.put("airlines", "two");
        // Calendar c = Calendar.getInstance();
        // c.set(Calendar.HOUR_OF_DAY, 12);
        // System.out.println(date2HHxmm(yyyyMMddxhhmmss2Date("2013-05-08 12:10:00")));}

        // {
        // Calendar c = Calendar.getInstance();
        // c.set(Calendar.DAY_OF_WEEK, 7);
        // System.out.println(date2MMddxww(c.getTime()));
        // }

        // {
        // File f = new File("E:\\java\\testSamples\\json.json");
        // BufferedReader br = null;
        // char[] buff = new char[1024];
        // StringBuilder sb = new StringBuilder();
        // int len = 0;
        // sb.toString().toUpperCase();
        // try {
        // br = new BufferedReader(new FileReader(f));
        // while ((len = br.read(buff)) != -1) {
        // sb.append(buff, 0, len);
        // }
        // } catch (FileNotFoundException e) {
        // e.printStackTrace();
        // } catch (IOException e) {
        // e.printStackTrace();
        // }
        //
        // String json = sb.toString();
        // // if (json.charAt(0) != '{') {
        // // json = json.replace(json.charAt(0), ' ');
        // // }
        // // System.out.println(json);
        // // System.out.println(json2Xml(json));
        //
        // if (json.charAt(0) != '{') {
        // json = json.replace(json.charAt(0), ' ');
        // }
        // json = xml2Json(json);
        // JSONObject output = new JSONObject();
        // String msgname = JSONObject.fromObject(json).getString("msgname");
        // msgname = msgname.replace("resp", "req");
        // output.put(msgname, json);
        // System.err.println(output.toString());
        // }

        {
            File f = new File("C:\\1.xml");
            BufferedReader br = null;
            char[] buff = new char[1024];
            StringBuilder sb = new StringBuilder();
            int len = 0;
            sb.toString().toUpperCase();
            try {
                br = new BufferedReader(new FileReader(f));
                while ((len = br.read(buff)) != -1) {
                    sb.append(buff, 0, len);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            String xml = sb.toString();

            String json = xml2Json(xml);

            System.err.println(json);
        }

    }

}
