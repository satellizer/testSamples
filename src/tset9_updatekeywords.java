import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.dom4j.DocumentException;

/*
 * @(#) tset9_updatekeywords.java
 * @Author:windheaven(mail) 2013-7-31
 * @Copyright (c) 2002-2013 Travelsky Limited. All rights reserved.
 */

/**
  * @author windheaven(mail) 2013-7-31
  * @version 1.0
  * @modifyed by windheaven(mail) description
  * @Function 类功能说明
  */
public class tset9_updatekeywords {

    /**
      * 创建一个新的实例 
      */
    public tset9_updatekeywords() {
        // TODO Auto-generated constructor stub
    }

    /**
      * main(这里用一句话描述这个方法的作用)
      * @param args
     * @throws DocumentException 
     * @throws IOException 
      */
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        File csv = new File("acquire_keywords0701.csv");
        File output = new File("acquire_keywords0701.sql");
        BufferedReader br = new BufferedReader(new FileReader(csv));
        BufferedWriter bw = new BufferedWriter(new FileWriter(output));
        String line = null;
        String head = "update shopmember set keywords='";
        String tail = "' where id=";

        while ((line = br.readLine()) != null) {
            String[] col = line.split(",");
            String col0 = col[0];
            String col1 = col[1];
            String col2 = col[2];
            String col3 = col[3];
            boolean isNum = true;
            for (int i = 0; i < col0.length(); i++) {
                char a = col0.charAt(i);
                if (a < '0' || a > '9') {
                    isNum = false;
                }
            }
            if (isNum) {
                StringBuffer sb = new StringBuffer();
                sb.append(head).append(col3).append(tail).append(col0).append(";");
                String tmp = sb.toString();
                System.out.println(tmp);

                bw.write(tmp);
                bw.newLine();
            }

        }
        br.close();
        bw.close();

    }
}
