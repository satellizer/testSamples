import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.http.HttpHost;
import org.apache.http.conn.params.ConnRoutePNames;

/*
 * @(#) test13_reg.java
 * @Author:windheaven(mail) 2013-5-8
 * @Copyright (c) 2002-2013 Travelsky Limited. All rights reserved.
 */

/**
  * @author windheaven(mail) 2013-5-8
  * @version 1.0
  * @modifyed by windheaven(mail) description
  * @Function test regular expression
  */
public class test13_reg {

    /**
      * main(这里用一句话描述这个方法的作用)
      * @param args
      */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Pattern p = Pattern.compile("(\\d+)\\.\\d+\\.\\d+\\.\\d+");
        Matcher m = p.matcher("http://113.108.143.171/baiyun/requestHandler");
        if (m.find()) {
            if (m.group(1).equals("10")) {
                System.out.println(m.group(1));
            } else {
                System.out.println(m.group(0));

            }
        } else {
            System.out.println("error website!");
        }
    }
}
