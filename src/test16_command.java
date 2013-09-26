import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

/*
 * @(#) test16_command.java
 * @Author:windheaven(mail) 2013-7-29
 * @Copyright (c) 2002-2013 Travelsky Limited. All rights reserved.
 */

/**
  * @author windheaven(mail) 2013-7-29
  * @version 1.0
  * @modifyed by windheaven(mail) description
  * @Function 类功能说明
  */
public class test16_command {

    /**
      * 创建一个新的实例 
      */
    public test16_command() {
        // TODO Auto-generated constructor stub
    }

    /**
      * main(这里用一句话描述这个方法的作用)
      * @param args
     * @throws IOException 
      */
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        Process proc = Runtime.getRuntime().exec("ipconfig");

        InputStream is = proc.getInputStream();

        BufferedReader br = new BufferedReader(new InputStreamReader(is, Charset.forName("gbk")));
        String line = null;

        while ((line = br.readLine()) != null) {

            System.out.println(line);
        }

    }
}
