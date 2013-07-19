import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.util.StopWatch;

/*
 * @(#) testLog4j.java
 * @Author:windheaven(mail) 2013-6-26
 * @Copyright (c) 2002-2013 Travelsky Limited. All rights reserved.
 */

/**
  * @author windheaven(mail) 2013-6-26
  * @version 1.0
  * @modifyed by windheaven(mail) description
  * @Function 类功能说明
  */
public class testLog4j {

    /**
      * 创建一个新的实例 
      */
    public testLog4j() {
        // TODO Auto-generated constructor stub
    }

    /**
      * main(这里用一句话描述这个方法的作用)
      * @param args
      */
    public static void main(String[] args) {

        // PropertyConfigurator.configure("resources/log4j.properties");
        // Logger logger = Logger.getLogger(testLog4j.class);
        // logger.debug(" debug ");
        // logger.error(" error ");
        // logger.info("info");

        // PropertyConfigurator.configure("resources/log4j.properties");
        // Logger logger = Logger.getLogger(testLog4j.class);
        // logger.debug(" debug ");
        // logger.error(" error ");
        // logger.info("info");

        // Logger logger2 = Logger.getLogger("p");
        // logger2.debug(" debug ");
        // logger2.error(" error ");
        // logger2.info("info");
        StopWatch sw = new StopWatch();
        sw.start();

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        sw.stop();
        System.out.println(sw.getLastTaskTimeMillis());
        System.out.println(sw.getTotalTimeMillis());
        System.out.println(sw.getTotalTimeSeconds());
        sw.start();
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        sw.stop();
        System.out.println(sw.getLastTaskTimeMillis());
        System.out.println(sw.getTotalTimeMillis());
        System.out.println(sw.getTotalTimeSeconds());

    }

}
