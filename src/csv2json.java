import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Calendar;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/*
 * @(#) test9_generateAirline.java
 * @Author:windheaven(mail) 2013-8-5
 * @Copyright (c) 2002-2013 Travelsky Limited. All rights reserved.
 */

/**
  * @author windheaven(mail) 2013-8-5
  * @version 1.0
  * @modifyed by windheaven(mail) description
  * @Function 类功能说明
  */
public class csv2json {

    /**
      * 创建一个新的实例 
      */
    public csv2json() {
        // TODO Auto-generated constructor stub
    }

    /**
      * main(这里用一句话描述这个方法的作用)
      * @param args
     * @throws FileNotFoundException 
      */
    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        File csv = new File(args[0]);
        File output = new File(args[1]);
        BufferedReader br = new BufferedReader(new FileReader(csv));
        BufferedWriter bw = new BufferedWriter(new FileWriter(output));
        String line = null;
        // pricess the head
        line = br.readLine();
        String[] head = line.split(",");
        JSONArray airlines = new JSONArray();

        while ((line = br.readLine()) != null) {

            System.out.println(line);
            JSONObject airline = new JSONObject();

            String[] col = line.split(",");
            for (int i = 0; i < col.length; i++) {
                airline.put(head[i], col[i].trim());

            }
            airline.put("createtime", Calendar.getInstance().getTimeInMillis());
            airlines.add(airline);
        }
        bw.write(airlines.toString());
        br.close();
        bw.close();

    }
}
